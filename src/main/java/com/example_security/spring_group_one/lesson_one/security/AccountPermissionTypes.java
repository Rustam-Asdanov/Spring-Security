package com.example_security.spring_group_one.lesson_one.security;

public enum AccountPermissionTypes {
    DATA_READ("data:read"),
    DATA_WRITE("data:write");

    private final String permission;

    AccountPermissionTypes(String permission) {
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
