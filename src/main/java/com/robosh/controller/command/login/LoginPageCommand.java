package com.robosh.controller.command.login;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageCommand implements Command {
    private final Logger logger = LogManager.getLogger(LoginPageCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("Forward to login page");
        request.getRequestDispatcher(PagesPath.LOGIN_PAGE).forward(request, response);
    }
}
