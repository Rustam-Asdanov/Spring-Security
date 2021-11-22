package com.example.spring_group_one.lesson_four.security;

import com.google.common.collect.Sets;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.spring_group_one.lesson_four.security.ApplicationPermission.*;

public enum ApplicationRole {

    GUEST(Sets.newHashSet(PAGE_READ,PAGE_WRITE)),
    ADMIN_NEW(Sets.newHashSet(PAGE_READ,PAGE_WRITE,BASE_READ)),
    ADMIN(Sets.newHashSet(PAGE_READ,PAGE_WRITE,BASE_READ,BASE_WRITE));

    private final Set<ApplicationPermission> permissionSet;

    ApplicationRole(Set<ApplicationPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationPermission> getPermissionSet() {
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> grantedAuthority = getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionInfo()))
                .collect(Collectors.toSet());

        return grantedAuthority;
    }


}
