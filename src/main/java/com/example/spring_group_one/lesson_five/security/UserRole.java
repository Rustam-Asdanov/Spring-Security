package com.example.spring_group_one.lesson_five.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.spring_group_one.lesson_five.security.UserPermission.*;

public enum UserRole {

    GUEST(Sets.newHashSet(READ)),
    ADMIN(Sets.newHashSet(READ,WRITE));

    private final Set<UserPermission> userPermissions;

    UserRole(Set<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public Set<UserPermission> getUserPermissions() {
        return userPermissions;
    }
}
