package com.robosh.controller.command.logout;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("sessionUser");
        response.sendRedirect(PagesRequest.PATH + PagesRequest.HOME_PAGE);
    }
}
