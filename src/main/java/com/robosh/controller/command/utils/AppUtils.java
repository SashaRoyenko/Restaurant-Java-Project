package com.robosh.controller.command.utils;

import com.robosh.model.entity.User;

import javax.servlet.http.HttpSession;

public class AppUtils {

    // Store user info in Session.
    public static void storeLoggedUser(HttpSession session, User loggedUser) {
        session.setAttribute("loggedUser", loggedUser);
        session.setAttribute("login", loggedUser.getEmail());
        session.setAttribute("login_password", loggedUser.getPassword());
    }

    // Get the user information stored in the session.
    public static User getLoggedUser(HttpSession session) {
        return (User) session.getAttribute("loggedUser");
    }
}