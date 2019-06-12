package com.robosh.controller.command.pages;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeCommand implements Command {
    private final Logger logger = LogManager.getLogger(HomeCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.info("Forward to home page");
        request.getRequestDispatcher(PagesPath.HOME_PAGE).forward(request, response);
    }
}
