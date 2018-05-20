package com.sunft.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by sunft on 2018/5/13.
 * 安全配置类，该类是Spring Security要求的类
 */
@EnableWebSecurity //启用web安全验证
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()  //静态文件设置都可以访问
                .antMatchers("/users/**").hasRole("ADMIN") //设置只有ADMIN角色才能访问users目录下的东西
                .and()
                .formLogin() //登录是基于Form表单的登录验证
                .loginPage("/login").failureUrl("/login-error"); //自定义登录页面和登录失败后的页面
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication() //认证信息存储于内存中
                .passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
                .withUser("sunft").password("123456").roles("ADMIN"); //在内存中初始化用户信息和角色

    }
}
