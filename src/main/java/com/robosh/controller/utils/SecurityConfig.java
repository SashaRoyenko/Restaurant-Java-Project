package com.robosh.controller.utils;


import com.robosh.model.entity.enums.Role;

import java.util.*;

public class SecurityConfig {

    private static final Map<Role, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        List<String> userAccess = new ArrayList<>();

        userAccess.add(PagesRequest.USER_PAGE);
        userAccess.add(PagesRequest.SHOPPING_CART_PAGE);
        mapConfig.put(Role.USER, userAccess);

        List<String> adminAccess = new ArrayList<>();

        adminAccess.add(PagesRequest.ADMIN_PAGE);
        adminAccess.add(PagesRequest.SHOPPING_CART_PAGE);

        mapConfig.put(Role.ADMIN, adminAccess);
    }

    public static Set<Role> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(Role role) {
        return mapConfig.get(role);
    }

}
