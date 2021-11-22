package com.example.spring_group_one.lesson_five.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.example.spring_group_one.lesson_five.security.UserPermission.WRITE;
import static com.example.spring_group_one.lesson_five.security.UserRole.GUEST;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/lesson/five","/lesson/five/registration").permitAll()
                .antMatchers("/lesson/five/user").hasRole(GUEST.name())
                .antMatchers("/lesson/five/admin").hasAuthority(WRITE.getPermissionInfo())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/lesson/five")
                .and()
                .logout()
                .logoutSuccessUrl("/lesson/five")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

}
