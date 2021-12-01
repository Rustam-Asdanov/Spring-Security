package com.example_security.spring_group_one.lesson_five.security;

public enum UserPermission {
    READ("data:read"),
    WRITE("data:write");

    private final String permissionInfo;

    UserPermission(String permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public String getPermissionInfo() {
        return permissionInfo;
    }
}
