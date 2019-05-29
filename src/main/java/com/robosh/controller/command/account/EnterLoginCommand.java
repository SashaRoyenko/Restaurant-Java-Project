package com.robosh.controller.command.account;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.utils.AppUtils;
import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterLoginCommand implements Command {

    private UserService userService;

    public EnterLoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        final String email = request.getParameter("login");
        final String password = request.getParameter("login_password");

        if (!userService.isUserExist(email,password)){
            String errorMessage = "Invalid Email or Password";
            request.setAttribute("errorMessage", errorMessage);
            //return "/jsp/loginClient.jsp";
            return "/jsp/login.jsp";
        }else {
            if (AppUtils.getLoggedUser(request.getSession()) != null){
                return "redirect#" + request.getContextPath() + "/tasty-restaurant/userAccount";
            }
            User user = userService.getUserByEmailAndPassword(email, password);
            if (user.getRole() == Role.ADMIN){
                AppUtils.storeLoggedUser(request.getSession(), user);
                return "redirect#" + request.getContextPath() + "/tasty-restaurant/adminAccount";
            }
            else {
                AppUtils.storeLoggedUser(request.getSession(), user);
                return "redirect#" + request.getContextPath() + "/tasty-restaurant/userAccount";
            }
        }
    }

}