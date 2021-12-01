package com.example_security.spring_group_one.lesson_four.security;

public enum ApplicationPermission {
    PAGE_READ("data read"),
    PAGE_WRITE("data write"),
    BASE_READ("data read"),
    BASE_WRITE("data write");

    private final String permissionInfo;

    ApplicationPermission(String permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public String getPermissionInfo() {
        return permissionInfo;
    }
}
