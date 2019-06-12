package com.robosh.controller.utils;

import com.robosh.model.entity.User;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    public static void storeUserInSession(HttpSession session, User sessionUser) {
        session.setAttribute("sessionUser", sessionUser);
    }

    public static User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute("sessionUser");
    }

    public static void removeSession(HttpSession session) {
        session.invalidate();
    }

}
