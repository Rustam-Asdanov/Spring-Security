package com.example.spring_group_one.lesson_three.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.example.spring_group_one.lesson_three.security.UserPermissions.USER_WRITE;
import static com.example.spring_group_one.lesson_three.security.UserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * from access the data using csrf you should add X-XSRF-TOKEN in head of postman
         */

        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/css/**","/script/**").permitAll()
                .antMatchers("/page","/page/*").hasRole(GUEST.name())
                .antMatchers(HttpMethod.DELETE,"/manager/users/**").hasAuthority(USER_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/manager/users/**").hasAuthority(USER_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"/manager/users/**").hasAuthority(USER_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/manager/users/**").hasAnyRole(ADMIN_JUNIOR.name(), ADMIN.name())
                .antMatchers("/manager/news/**").hasAnyRole(ADMIN_JUNIOR.name(), ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/",true)
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        UserDetails user_one = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("123"))
                .roles(GUEST.name())
                .build();

        UserDetails user_admin_one = User.builder()
                .username("mati")
                .password(passwordEncoder.encode("1111"))
                .authorities(ADMIN_JUNIOR.getGrantedAuthorities())
                .build();

        UserDetails user_admin_bash = User.builder()
                .username("khan")
                .password(passwordEncoder.encode("kayf"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                user_one,
                user_admin_one,
                user_admin_bash
        );
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
}
