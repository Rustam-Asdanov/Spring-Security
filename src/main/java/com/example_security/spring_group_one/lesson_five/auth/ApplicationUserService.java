package com.example_security.spring_group_one.lesson_five.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserFilter applicationUserFilter;

    public ApplicationUserService(ApplicationUserFilter applicationUserFilter) {
        this.applicationUserFilter = applicationUserFilter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserFilter
                .selectApplicationByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("username with %s not found",username))
                );
    }
}
