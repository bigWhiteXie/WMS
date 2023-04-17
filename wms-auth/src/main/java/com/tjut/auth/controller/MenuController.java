package com.tjut.auth.controller;

import com.tjut.auth.model.dto.MenuDto;
import com.tjut.auth.model.po.TSFunction;
import com.tjut.auth.service.impl.TSUserServiceImpl;
import com.tjut.resp.WmsResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    TSUserServiceImpl tsUserService;

    @RequestMapping("menu")
    public WmsResp<List<MenuDto>> menuList(String userId){
        List<MenuDto> menus = tsUserService.getMenus(userId);
        WmsResp<List<MenuDto>> resp = new WmsResp<>(200, menus);
        return resp;
    }

}
