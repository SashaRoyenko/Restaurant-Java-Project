package com.robosh.controller.command.registration;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(RegisterUserCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("Forward to registration page");
        request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE).forward(request, response);
    }
}
