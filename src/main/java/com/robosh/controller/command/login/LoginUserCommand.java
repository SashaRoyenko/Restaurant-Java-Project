package com.robosh.controller.command.login;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.User;
import com.robosh.model.exceptions.UserIsNotExist;
import com.robosh.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUserCommand implements Command {
    private UserService userService;
    private final Logger logger = LogManager.getLogger(LoginUserCommand.class);

    public LoginUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("login");
        final String password = request.getParameter("login_password");

        User user;
        if (SessionUtil.getUserFromSession(request.getSession()) != null) {
            user = SessionUtil.getUserFromSession(request.getSession());
            logger.info("Receive user from session");
            forwardUser(user, request, response);
        } else {
            try {
                userService.isUserExist(email, password);
            } catch (UserIsNotExist userIsNotExist) {
                logger.info(userIsNotExist);
                request.getRequestDispatcher(PagesPath.LOGIN_PAGE + "?userExist=false").forward(request, response);
                return;
            }
            user = userService.getUserByEmailAndPassword(email, password);
            logger.info("Receive user by email and password");
            SessionUtil.storeUserInSession(request.getSession(), user);
            forwardUser(user, request, response);
        }
    }

    private void forwardUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (user.getRole()) {
            case ADMIN:
                response.sendRedirect(PagesRequest.PATH + PagesRequest.ADMIN_PAGE);
                break;
            case USER:
                response.sendRedirect(PagesRequest.PATH + PagesRequest.USER_PAGE);
                break;
            default:
                response.sendRedirect(PagesRequest.PATH + PagesRequest.HOME_PAGE);
        }
    }
}
