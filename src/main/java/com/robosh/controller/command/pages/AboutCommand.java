package com.robosh.controller.command.pages;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher(PagesPath.ABOUT_PAGE).forward(request, response);
    }
}
