package com.tjut.authBase.util;

import com.alibaba.fastjson.JSON;
import com.tjut.common.model.UserDto;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserHolder {
    public static UserDto getUser(){
        String json = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = JSON.parseObject(json,UserDto.class);
        return userDto;
    }
}
