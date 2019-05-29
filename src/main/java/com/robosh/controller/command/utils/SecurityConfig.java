package com.robosh.controller.command.utils;

import com.robosh.model.entity.enums.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SecurityConfig {
    // String: Role
    // List<String>: urlPatterns.
    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        // Конфигурация для роли "USER".
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/userAccount");

        mapConfig.put(Role.USER, urlPatterns1);

        // Конфигурация для роли "ADMIN".
        List<String> urlPatterns2 = new ArrayList<String>();

        urlPatterns2.add("/adminAccount");

        mapConfig.put(Role.ADMIN, urlPatterns2);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(Role role) {
        return mapConfig.get(role);
    }

}