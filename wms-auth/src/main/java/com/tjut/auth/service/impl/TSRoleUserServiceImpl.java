package com.tjut.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.auth.mapper.TSRoleUserMapper;
import com.tjut.auth.model.po.TSRoleUser;
import com.tjut.auth.service.TSRoleUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * InnoDB free: 599040 kB; (`userid`) REFER `jeecg/t_s_user`(`i 服务实现类
 * </p>
 *
 * @author codeXie
 */
@Slf4j
@Service
public class TSRoleUserServiceImpl extends ServiceImpl<TSRoleUserMapper, TSRoleUser> implements TSRoleUserService {

}
