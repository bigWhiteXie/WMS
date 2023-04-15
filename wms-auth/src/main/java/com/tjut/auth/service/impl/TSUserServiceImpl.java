package com.tjut.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.auth.mapper.TSUserMapper;
import com.tjut.auth.model.dto.UserDto;
import com.tjut.auth.model.po.*;
import com.tjut.auth.service.*;
import com.tjut.exception.WmsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    TSDepartService tsDepartService;

    @Autowired
    TSUserOrgService tsUserOrgService;

    @Autowired
    TSRoleFunctionService tsRoleFunctionService;

    @Autowired
    TSOperationService tsOperationService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TSUser user = this.lambdaQuery().eq(TSUser::getUsername, s).one();
        if(null == user){
            throw new WmsException(401,"用户名或密码错误");
        }
        //获取用户角色列表以及function
        List<String> funIds = tsUserMapper.getFunIds(user.getId());
        List<TSFunction> funList = tsUserMapper.getFunctionByRoleId(funIds);

        List<TSOperation> operations = tsOperationService.lambdaQuery().in(TSOperation::getFunctionid, funIds).list();

        //获取用户部门信息
        TSUserOrg org = tsUserOrgService.lambdaQuery().eq(TSUserOrg::getUserId, user.getId()).one();
        TSDepart depart = tsDepartService.lambdaQuery().eq(TSDepart::getId, org.getOrgId()).one();


        UserDto userDto = new UserDto(user.getId(),user.getUsername(), depart.getId(), depart.getDepartname());
        List<String> authorities = new ArrayList<>();

        funList.stream().forEach((item)->authorities.add(item.getFunctionname()));
        operations.stream().forEach((item)->authorities.add(item.getOperationcode()));

        String jsonString = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(jsonString).password(user.getPassword()).authorities(authorities.toArray(new String[0])).build();

        return userDetails;
    }
}
