package com.robosh.controller.utils;

public class PagesPath {
    private static final String PAGE_PATH = "/jsp";
    private static final String USER_PATH = PAGE_PATH + "/account";
    private static final String ERROR_PATH = PAGE_PATH + "/error";

    public static final String HOME_PAGE = PAGE_PATH + "/home.jsp";
    public static final String LOGIN_PAGE = PAGE_PATH + "/loginUser.jsp";
    public static final String REGISTRATION_PAGE = PAGE_PATH + "/registration.jsp";
    public static final String ADMIN_PAGE = USER_PATH + "/adminAccount.jsp";
    public static final String USER_PAGE = USER_PATH + "/userAccount.jsp";
    public static final String ABOUT_PAGE = PAGE_PATH + "/about.jsp";
    public static final String MENU_PAGE = PAGE_PATH + "/menu.jsp";
    public static final String ERROR_403 = ERROR_PATH + "/403.jsp";
    public static final String ERROR_404 = ERROR_PATH + "/404.jsp";

}
