package com.robosh.controller.utils;

public class InputDataUtil {
    private static final String SPACE = "[\\s]";
    private static final String CHECK_NAME = "[A-za-z\\p{IsCyrillic}.'-]{3,20}";
    private static final String CHECK_EMAIL = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}";
    private static final String CHECK_PHONE = "[0-9\\+]{10,15}";
    private static final String CHECK_PASSWORD = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}";

    public static String removeSpaces(String str) {
        return str.replaceAll(SPACE, "");
    }

    public static boolean isCorrectPhone(String phone) {
        return phone.matches(CHECK_PHONE);
    }

    public static boolean isCorrectName(String name) {
        return name.matches(CHECK_NAME);
    }

    public static boolean isCorrectEmail(String email) {
        return email.matches(CHECK_EMAIL);
    }

    public static boolean isCorrectPassword(String password) {
        return password.matches(CHECK_PASSWORD);
    }


}
