package com.example.spring_group_one.lesson_four.security;

import com.example.spring_group_one.lesson_four.auth.ApplicationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.example.spring_group_one.lesson_four.security.ApplicationPermission.BASE_READ;
import static com.example.spring_group_one.lesson_four.security.ApplicationPermission.BASE_WRITE;
import static com.example.spring_group_one.lesson_four.security.ApplicationRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    public SecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/lesson_four/page","/css/**","/script/**","/img/**").permitAll()
                .antMatchers("/lesson_four/page/user").hasRole(GUEST.name())
                .antMatchers("/lesson_four/page/admin/pro").hasAuthority(BASE_WRITE.getPermissionInfo())
                .antMatchers("/lesson_four/page/admin").hasAuthority(BASE_READ.getPermissionInfo())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/lesson_four/page/user",true)
                .and()
                .rememberMe()
                .tokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(21))
                .key("good")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET")) // if we disable csrf
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID","remember-me")
                .logoutSuccessUrl("/login");

    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        UserDetails userOne = User.builder()
//                .username("tom")
//                .password(passwordEncoder.encode("111"))
//                .roles(GUEST.name())
//                .build();
//
//        UserDetails userTwo = User.builder()
//                .username("user-two")
//                .password(passwordEncoder.encode("123"))
//                .authorities(ADMIN_NEW.getGrantedAuthorities())
//                .build();
//
//        UserDetails userThree = User.builder()
//                .username("user-three")
//                .password(passwordEncoder.encode("222"))
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                userOne,
//                userTwo,
//                userThree
//        );
//    }


//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails userOne = User.builder()
//                .username("tom")
//                .password(passwordEncoder.encode("111"))
//                .roles(GUEST.name())
//                .build();
//
//        UserDetails userTwo = User.builder()
//                .username("user-two")
//                .password(passwordEncoder.encode("123"))
//                .authorities(ADMIN_NEW.getGrantedAuthorities())
//                .build();
//
//        UserDetails userThree = User.builder()
//                .username("user-three")
//                .password(passwordEncoder.encode("222"))
//                .authorities(ADMIN.getGrantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                userOne,
//                userTwo,
//                userThree
//        );
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
