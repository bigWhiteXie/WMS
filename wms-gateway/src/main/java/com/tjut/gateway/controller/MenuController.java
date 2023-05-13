package com.tjut.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.tjut.common.model.UserDto;

import com.tjut.gateway.feignclients.AuthServiceClient;

import com.tjut.common.resp.WmsResp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    AuthServiceClient authServiceClient;

    @Autowired
    TokenStore tokenStore;
    @RequestMapping("menu")
    public WmsResp getMenuList(ServerWebExchange exchange){

        String token = getToken(exchange);
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
        Map<String, Object> map = accessToken.getAdditionalInformation();
        String json = (String) map.get("user_name");
        UserDto userDto = JSON.parseObject(json, UserDto.class);
        WmsResp resp = authServiceClient.menu(userDto.getUserId());
        return resp;
    }

    private String getToken(ServerWebExchange exchange) {
        String tokenStr = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StringUtils.isBlank(tokenStr)) {
            return null;
        }
        String token = tokenStr.split(" ")[1];
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return token;
    }

}
