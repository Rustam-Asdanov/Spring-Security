package com.example.spring_group_one.lesson_two.security;

public enum UserPermissions {
    NEWS_READ("news:read"),
    NEWS_WRITE("news:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
