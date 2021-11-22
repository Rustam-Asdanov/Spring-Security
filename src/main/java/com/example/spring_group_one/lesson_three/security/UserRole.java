package com.example.spring_group_one.lesson_three.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.spring_group_one.lesson_three.security.UserPermissions.*;

public enum UserRole {
    GUEST(Sets.newHashSet(NEWS_READ)),
    ADMIN_JUNIOR(Sets.newHashSet(NEWS_READ,NEWS_WRITE,USER_READ)),
    ADMIN(Sets.newHashSet(NEWS_READ,NEWS_WRITE,USER_READ,USER_WRITE));

    private final Set<UserPermissions> userPermissionsSet;

    UserRole(Set<UserPermissions> userPermissionsSet) {
        this.userPermissionsSet = userPermissionsSet;
    }

    public Set<UserPermissions> getUserPermissionsSet() {
        return userPermissionsSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permission = getUserPermissionsSet().stream()
                .map(userPermissions -> new SimpleGrantedAuthority(userPermissions.getPermission()))
                .collect(Collectors.toSet());
        permission.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permission;
    }
}
