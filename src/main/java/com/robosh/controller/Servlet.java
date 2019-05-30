package com.robosh.controller;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.account.EnterLoginCommand;
import com.robosh.controller.command.account.LogOutCommand;
import com.robosh.controller.command.account.RegistrationCommand;
import com.robosh.controller.command.directions.*;
import com.robosh.service.OrderService;
import com.robosh.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put("login", new EnterLoginCommand(new UserService()));
        commands.put("loginUser", new LoginUserCommand());
        commands.put("registration", new RegisterUserCommand());
        commands.put("registerUser", new RegistrationCommand(new UserService()));
        commands.put("home", new HomeCommand());
        commands.put("menu", new MenuCommand());
        commands.put("about", new AboutCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("userAccount", new UserAccountCommand());
        commands.put("adminAccount", new AdminAccountCommand(new OrderService()));
        commands.put("403", new Error403Command());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandKey = getRequestPath(request);//get next command key
        Command command = commands.get(commandKey);
        if (command == null) { //if there is no command with such key, request dispatcher home page
            request.getRequestDispatcher("/tasty-restaurant/home").forward(request, response);
        }else {
            String nextPage = command.execute(request, response);
            if (isRedirect(nextPage)){
                System.out.println("redirect servlet: " + nextPage + "\n");
                response.sendRedirect(nextPage.replaceAll("redirect#", ""));
            }
            else{
                System.out.println("forward servlet: " + nextPage +"\n");
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }


    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        return pathURI.replaceAll(".*/tasty-restaurant/", "");
    }

    private boolean isRedirect(String string){
        return string.contains("redirect#");
    }
}
