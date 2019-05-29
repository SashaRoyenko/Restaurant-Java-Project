package com.robosh.controller.command.account;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.utils.AppUtils;
import com.robosh.model.entity.User;
import com.robosh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterLoginCommand implements Command {

    private UserService userService;

    public EnterLoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String email = request.getParameter("login");
        final String password = request.getParameter("login_password");

        //todo check is input data is correct (length of psw e.g.)
        if (inputWrongData(email, password)){
            String errorMessage = "Invalid Email or Password";
            request.setAttribute("errorMessage", errorMessage);
            return "/jsp/loginUser.jsp";
        }else {
            if (AppUtils.getLoggedUser(request.getSession()) != null){
                return "redirect#" + request.getContextPath() + "/tasty-restaurant/UserAccount";
            }
            User user = userService.getUserByEmailAndPassword(email, password);
            System.out.println(user);
            AppUtils.storeLoggedUser(request.getSession(), user);
            return "redirect#" + request.getContextPath() + "/tasty-restaurant/UserAccount";
        }
    }

    private boolean inputWrongData(String email, String password){
        return !userService.isUserExist(email, password);
    }
}
