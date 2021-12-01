package com.example_security.demoTwo.simpleTest;

import static com.example_security.demoTwo.security.ApplicationUserPermission.COURSE_READ;
import static com.example_security.demoTwo.security.ApplicationUserRole.*;

public class JustForRelax {
    public static void main(String[] args){
        System.out.println(STUDENT.getGrantedAuthorities());
        System.out.println(ADMIN.getGrantedAuthorities());
        System.out.println(ADMINTRAINEE.getGrantedAuthorities());
        System.out.println(COURSE_READ.getPermission());
    }
}
