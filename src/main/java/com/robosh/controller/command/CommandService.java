package com.robosh.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandService {
    public static boolean isUSerLogged(HttpServletRequest request, String email){
        return email.equals(request.getSession().getAttribute("email"));
    }

    public static void unlogUser(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.removeAttribute("userFirstName");
        session.removeAttribute("userSecondName");
        session.removeAttribute("role");
        session.removeAttribute("password");
    }
}
