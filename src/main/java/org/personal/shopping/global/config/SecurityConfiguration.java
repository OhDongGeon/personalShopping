package org.personal.shopping.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/resources/**", "/", "/member/login").permitAll() // 정적 리소스에 대한 접근 허용
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/member/login")
            .and()
            .cors()
            .and()
            .csrf()
            .and()
            .httpBasic();
    }

}
