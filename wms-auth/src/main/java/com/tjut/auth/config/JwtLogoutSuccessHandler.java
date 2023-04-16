package com.tjut.auth.config;

import com.alibaba.fastjson.JSON;
import com.tjut.auth.model.UserDto;
import com.tjut.redis.RedisKey;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String token = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(token) && token.startsWith("Bearer ")) {
            token = token.substring(7);
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            String json = (String) accessToken.getAdditionalInformation().get("user_name");
            UserDto userDto = JSON.parseObject(json, UserDto.class);
            tokenStore.removeAccessToken(accessToken);
            redisTemplate.delete(RedisKey.USER_MENUS+userDto.getUserId());
            log.debug("用户：{} 退出成功",json);
        }

        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("退出成功");
    }
}
