package com.tjut.auth.config;

import com.tjut.auth.service.impl.TSUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author codeXie
 * @version 1.0
 * @description 安全管理配置
 * @date 2022/9/26 20:53
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    DaoAuthenticationProviderCustom daoAuthenticationProviderCustom;

    @Autowired
    TSUserServiceImpl tsUserService;

    @Autowired
    JwtLogoutSuccessHandler jwtLogoutSuccessHandler;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //添加自定义的Provider到provider列表中
//        auth.authenticationProvider(daoAuthenticationProviderCustom);
//
//    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
//        //密码为明文方式
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }

    //配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/auth/r/**").authenticated()//访问/r开始的请求需要认证通过
            .anyRequest().permitAll()//其它请求全部放行
            .and()
            .formLogin().successForwardUrl("/login-success");//登录成功跳转到/login-success

        http.logout().logoutUrl("/logout")
                .logoutSuccessHandler(jwtLogoutSuccessHandler)
                .and().csrf().disable();//退出地址

    }


    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        /**
         $2a$10$1sp7I0OdYH3Azs/2lK8YYeuiaGZzOGshGT9j.IYArZftsGNsXqlma
         $2a$10$m983E2nmJ7ITlesbXzjbzO/M7HL2wP8EgpgX.pPACDm1wG38Lt.na
         $2a$10$rZvathrW98vVPenLhOnl0OMpUtRTdBkWJ45IkIsTebITS9AFgKqGK
         $2a$10$2gaMKWCRoKdc42E0jsq7b.munjzOSPOM4yr3GG9M6194E7dOH5LyS
         $2a$10$I/n93PIKpKL8m4O3AuT5kuZncZhfqV51bfx5sJrplnYoM7FimdboC
        */


        boolean matches = passwordEncoder.matches("11111", "$2a$10$m983E2nmJ7ITlesbXzjbzO/M7HL2wP8EgpgX.pPACDm1wG38Lt.na");
        System.out.println(matches);
    }

}
