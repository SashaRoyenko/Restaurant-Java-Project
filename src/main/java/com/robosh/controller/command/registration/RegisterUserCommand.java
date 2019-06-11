package com.robosh.controller.command.registration;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.login.LoginUserCommand;
import com.robosh.controller.utils.InputDataUtil;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.connection.ConnectionPoolHolder;
import com.robosh.model.entity.User;
import com.robosh.model.exceptions.EmailIsAlreadyTaken;
import com.robosh.model.exceptions.PhoneIsAlreadyTaken;
import com.robosh.service.OrderProductsService;
import com.robosh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUserCommand implements Command {
    private UserService userService;
    private OrderProductsService orderProductsService;

    public RegisterUserCommand(UserService userService, OrderProductsService orderProductsService) {
        this.userService = userService;
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String firstName = InputDataUtil.removeSpaces(request.getParameter("firstName"));
        final String lastName = InputDataUtil.removeSpaces(request.getParameter("lastName"));
        final String phone = InputDataUtil.removeSpaces(request.getParameter("phone"));
        final String email = InputDataUtil.removeSpaces(request.getParameter("email"));
        final String password = InputDataUtil.removeSpaces(request.getParameter("password"));
        final String confirmedPassword = InputDataUtil.removeSpaces(request.getParameter("confirmedPassword"));

        if (password.equals(confirmedPassword)) {
            if(!InputDataUtil.isCorrectName(firstName) || !InputDataUtil.isCorrectName(lastName)){
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?correctName=false").forward(request, response);
                return;
            }

            if(!InputDataUtil.isCorrectPhone(phone)){
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?correctPhone=false").forward(request, response);
                return;
            }

            if(!InputDataUtil.isCorrectEmail(email)){
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?correctEmail=false").forward(request, response);
                return;
            }

            if(!InputDataUtil.isCorrectPassword(password)){
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?correctPassword=false").forward(request, response);
                return;
            }

            try {
                User user = User.newBuilder()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setPassword(password)
                        .setPhone(phone)
                        .build();
                userService.createUser(user);
                user = userService.getUserByEmailAndPassword(email, password);
                SessionUtil.storeUserInSession(request.getSession(), user);
                new LoginUserCommand(userService).execute(request, response);
            } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?emailExist=true").forward(request, response);
            } catch (PhoneIsAlreadyTaken phoneIsAlreadyTaken) {
                request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?phoneExist=true").forward(request, response);
            }
        } else {
            request.getRequestDispatcher(PagesPath.REGISTRATION_PAGE + "?passwordMatch=false").forward(request, response);
        }

    }

}
