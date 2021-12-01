package com.example_security.spring_group_one.lesson_one.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example_security.spring_group_one.lesson_one.security.AccountRoles.ADMIN;
import static com.example_security.spring_group_one.lesson_one.security.AccountRoles.GUEST;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/group_one/main/*","/css/**","/script/**")
                .permitAll()
                .antMatchers("/group_one/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails user_one = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("tomson"))
                .roles(GUEST.name())
                .build();
        UserDetails user_admin_one = User.builder()
                .username("john")
                .password(passwordEncoder.encode("jonny"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                user_one,
                user_admin_one
        );
    }


}
