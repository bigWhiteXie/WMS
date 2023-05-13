package com.tjut.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.auth.mapper.TSFunctionMapper;
import com.tjut.auth.mapper.TSUserMapper;
import com.tjut.auth.model.dto.MenuDto;
import com.tjut.auth.model.dto.UserDto;
import com.tjut.auth.model.po.*;
import com.tjut.auth.service.*;
import com.tjut.common.exception.WmsException;
import com.tjut.common.redis.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * InnoDB free: 599040 kB; (`id`) REFER `jeecg/t_s_base_user`(` 服务实现类
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@Service
public class TSUserServiceImpl extends ServiceImpl<TSUserMapper, TSUser> implements TSUserService, UserDetailsService {
    @Autowired
    TSUserMapper tsUserMapper;
    @Autowired
    TSFunctionMapper tsFunctionMapper;
    @Autowired
    TSDepartService tsDepartService;

    @Autowired
    TSUserOrgService tsUserOrgService;

    @Autowired
    TSRoleFunctionService tsRoleFunctionService;

    @Autowired
    TSOperationService tsOperationService;

    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TSUser user = this.lambdaQuery().eq(TSUser::getUsername, s).one();
        if(null == user){
            throw new WmsException(401,"用户名或密码错误");
        }
        //获取用户角色列表以及function
        List<String> funIds = tsUserMapper.getFunIds(user.getId());
        List<TSFunction> funList = tsUserMapper.getFunctionByIds(funIds);

        List<TSOperation> operations = tsOperationService.lambdaQuery().in(TSOperation::getFunctionid, funIds).list();

        //获取用户部门信息
        TSUserOrg org = tsUserOrgService.lambdaQuery().eq(TSUserOrg::getUserId, user.getId()).one();
        TSDepart depart = tsDepartService.lambdaQuery().eq(TSDepart::getId, org.getOrgId()).one();


        UserDto userDto = new UserDto(user.getId(),user.getUsername(), depart.getId(), depart.getDepartname());
        List<String> authorities = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<>();
        funList.stream().forEach((item)->{
            if(StringUtils.isNotEmpty(item.getFunctionurl())){
                urls.add(item.getFunctionurl());
            }
        });
        //将用户能够访问的urls添加到redis中
        redisTemplate.opsForSet().add(RedisKey.USER_MENUS+user.getId(),urls.toArray(new String[0]));
        //将用户能执行的操作添加到authorities中
        operations.stream().forEach((item)->authorities.add(item.getOperationcode()));

        String jsonString = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(jsonString).password(user.getPassword()).authorities(authorities.toArray(new String[0])).build();

        return userDetails;
    }


    @Override
    public List<MenuDto> getMenus(String userId) {

        //获取用户角色列表以及function
        List<String> funIds = tsUserMapper.getFunIds(userId);
        List<MenuDto> treeMenu = tsFunctionMapper.getMenuTree(funIds);

        return treeMenu;
    }

//    private List<MenuDto> generatorMenuTree(List<TSFunction> list,String parentId){
//        ArrayList<MenuDto> tree = new ArrayList<>();
//        Iterator<TSFunction> iterator = list.iterator();
//        while(iterator.hasNext()){
//            TSFunction item = iterator.next();
//            if(parentId == item.getParentfunctionid() || (parentId!= null && parentId.equals(item.getParentfunctionid()))){
//                MenuDto menuDto = new MenuDto();
//                menuDto.setFunction(item);
//                menuDto.setChildNodes(generatorMenuTree(list,item.getId()));
//                tree.add(menuDto);
//                iterator.remove();
//            }
//        }
//       return tree;
//    }

    static class FunComparatpr implements Comparator<TSFunction>{

        @Override
        public int compare(TSFunction o1, TSFunction o2) {
            if(!o1.getFunctionlevel().equals(o2.getFunctionlevel())){
                return o1.getFunctionlevel() - o2.getFunctionlevel();
            }
            return Integer.valueOf(o1.getFunctionorder()) - Integer.valueOf(o2.getFunctionorder());
        }
    }
}
