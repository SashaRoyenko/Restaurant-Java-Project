package com.robosh.controller.command.registration;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.login.LoginUserCommand;
import com.robosh.model.entity.User;
import com.robosh.model.exceptions.EmailIsAlreadyTaken;
import com.robosh.model.exceptions.PhoneIsAlreadyTaken;
import com.robosh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterUserCommand implements Command {
    private UserService userService;

    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String firstName = request.getParameter("firstName");
        final String lastName = request.getParameter("lastName");
        final String phone = request.getParameter("phone");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String confirmedPassword = request.getParameter("confirmedPassword");

        if (password.equals(confirmedPassword)) {

            User user = User.newBuilder()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPassword(password)
                    .setPhone(phone)
                    .build();
            System.out.println(user);
            try {
                userService.createUser(user);
            } catch (EmailIsAlreadyTaken | PhoneIsAlreadyTaken emailIsAlreadyTaken) {
                emailIsAlreadyTaken.printStackTrace();
                new RegistrationPageCommand().execute(request, response);
            }
        }
        new LoginUserCommand(userService).execute(request, response);
    }
}
