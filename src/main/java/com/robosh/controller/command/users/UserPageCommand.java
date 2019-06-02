package com.robosh.controller.command.users;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(PagesPath.USER_PAGE).forward(request, response);
    }
}

