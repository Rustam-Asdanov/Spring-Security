package com.example.spring_group_one.lesson_one.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.spring_group_one.lesson_one.security.AccountPermissionTypes.*;

public enum AccountRoles {
    GUEST(Sets.newHashSet(DATA_READ)),
    ADMIN(Sets.newHashSet(DATA_READ,DATA_WRITE));

    private final Set<AccountPermissionTypes> permissionTypes;

    AccountRoles(Set<AccountPermissionTypes> permissionTypes) {
        this.permissionTypes = permissionTypes;
    }
}
