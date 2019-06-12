package com.robosh.controller.command.logout;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {
    private final Logger logger = LogManager.getLogger(LogoutCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("sessionUser");
        SessionUtil.removeSession(request.getSession());
        logger.info("Remove session");
        logger.info("Redirect to home page");
        response.sendRedirect(PagesRequest.PATH + PagesRequest.HOME_PAGE);
    }
}
