package com.tjut.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.auth.model.dto.MenuDto;
import com.tjut.auth.model.po.TSUser;

import java.util.List;

/**
 * <p>
 * InnoDB free: 599040 kB; (`id`) REFER `jeecg/t_s_base_user`(` 服务类
 * </p>
 *
 * @author codeXie
 * @since 2023-04-14
 */
public interface TSUserService extends IService<TSUser> {

    List<MenuDto> getMenus(String userId);

}
