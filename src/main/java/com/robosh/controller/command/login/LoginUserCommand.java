package com.robosh.controller.command.login;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.pages.HomeCommand;
import com.robosh.controller.command.users.AdminPageCommand;
import com.robosh.controller.command.users.UserPageCommand;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.User;
import com.robosh.service.OrderService;
import com.robosh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginUserCommand implements Command {
    private UserService userService;
    private HomeCommand homeCommand;

    public LoginUserCommand(UserService userService) {
        this.userService = userService;
        homeCommand = new HomeCommand();
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("login");
        final String password = request.getParameter("login_password");

        if (!userService.isUserExist(email, password)) {
            homeCommand.execute(request, response);
        }
        User user;
        if (SessionUtil.getUserFromSession(request.getSession()) != null) {
            user = SessionUtil.getUserFromSession(request.getSession());
            forwardUser(user, request, response);
        } else {
            user = userService.getUserByEmailAndPassword(email, password);
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
