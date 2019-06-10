package com.robosh.controller;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.basket.BasketCommand;
import com.robosh.controller.command.login.LoginPageCommand;
import com.robosh.controller.command.login.LoginUserCommand;
import com.robosh.controller.command.logout.LogoutCommand;
import com.robosh.controller.command.order.OrderCommand;
import com.robosh.controller.command.pages.AboutCommand;
import com.robosh.controller.command.pages.HomeCommand;
import com.robosh.controller.command.pages.MenuCommand;
import com.robosh.controller.command.pages.ShoppingCartCommand;
import com.robosh.controller.command.registration.RegisterUserCommand;
import com.robosh.controller.command.registration.RegistrationPageCommand;
import com.robosh.controller.command.users.AdminPageCommand;
import com.robosh.controller.command.users.UserPageCommand;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.model.dao.DishDao;
import com.robosh.service.*;
import com.sun.org.apache.xpath.internal.operations.Or;

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
    public void init() throws ServletException {
        DishService dishService = new DishService();
        DrinkService drinkService = new DrinkService();
        OrderProductsService orderProductsService = new OrderProductsService();
        OrderService orderService = new OrderService();
        commands = new HashMap<>();
        commands.put("/", new HomeCommand());
        commands.put(PagesRequest.HOME_PAGE, new HomeCommand());
        commands.put(PagesRequest.MENU_PAGE, new MenuCommand(dishService, drinkService));
        commands.put(PagesRequest.ABOUT_PAGE, new AboutCommand());
        commands.put(PagesRequest.SHOPPING_CART_PAGE, new ShoppingCartCommand(orderProductsService));
        commands.put(PagesRequest.LOGIN_PAGE, new LoginPageCommand());
        commands.put(PagesRequest.LOGIN, new LoginUserCommand(new UserService()));
        commands.put(PagesRequest.LOGOUT, new LogoutCommand());
        commands.put(PagesRequest.REGISTRATION_PAGE, new RegistrationPageCommand());
        commands.put(PagesRequest.REGISTRATION, new RegisterUserCommand(new UserService(), orderProductsService));
        commands.put(PagesRequest.ADMIN_PAGE, new AdminPageCommand(new OrderService()));
        commands.put(PagesRequest.USER_PAGE, new UserPageCommand(orderService));
        commands.put(PagesRequest.BASKET, new BasketCommand(dishService, drinkService, orderProductsService));
        commands.put(PagesRequest.ORDER, new OrderCommand(orderService));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        executeRequest(request, response);
    }

    private void executeRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getPathInfo();
        Command currentCommand = commands.get(uri);
        if (currentCommand == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            currentCommand.execute(request, response);
        }
    }
}
