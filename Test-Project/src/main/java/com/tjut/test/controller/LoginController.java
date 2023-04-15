package com.tjut.test.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codeXie
 * @version 1.0
 * @description 测试controller
 * @date 2022/9/27 17:25
 */
@Slf4j
@RestController
public class LoginController {




    @RequestMapping("/login-success")
    public String loginSuccess() {

        return "登录成功";
    }

    @RequestMapping("/r/r1")
    public String r1() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        Object authority = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        log.info("principal:{}",principal);
        log.info("details:{}",details);
        log.info("authorities:{}",authority);
        return "访问r1资源";
    }

    @RequestMapping("/r/r2")

    public String r2() {
        return "访问r2资源";
    }

}
