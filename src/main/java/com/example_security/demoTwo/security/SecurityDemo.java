package com.example_security.demoTwo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example_security.demoTwo.security.ApplicationUserPermission.COURSE_WRITE;
import static com.example_security.demoTwo.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityDemo extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityDemo(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/main").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("123456"))
//                .roles(STUDENT.name()) // ROLE_STUDENT
                .authorities(STUDENT.getGrantedAuthorities())
                .build();
        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                annaSmithUser,
                lindaUser,
                tomUser
        );
    }
}
