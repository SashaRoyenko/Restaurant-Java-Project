package com.robosh.controller.command.pages;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.login.LoginPageCommand;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.User;
import com.robosh.service.OrderProductsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShoppingCartCommand implements Command {
    private final Logger logger = LogManager.getLogger(ShoppingCartCommand.class);
    private OrderProductsService orderProductsService;

    public ShoppingCartCommand(OrderProductsService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (SessionUtil.getUserFromSession(request.getSession()) != null) {
            User user = SessionUtil.getUserFromSession(request.getSession());
            List<Dish> dishList = orderProductsService.selectDishes(user);
            logger.info("Received dish list");
            List<Drink> drinkList = orderProductsService.selectDrinks(user);
            logger.info("Received drink list");
            float totalPrice = orderProductsService.getTotalPrice(user);
            logger.info("Receive total price");
            request.getSession().setAttribute("userDishes", dishList);
            request.getSession().setAttribute("userDrinks", drinkList);
            request.getSession().setAttribute("totalPrice", totalPrice);
            logger.info("Set parameters");
            logger.info("Forward to shopping card page");
            request.getRequestDispatcher(PagesPath.SHOPPING_CART_PAGE).forward(request, response);
        } else {
            logger.info("There is no authorise user - redirect to login page");
            response.sendRedirect(PagesRequest.PATH + PagesRequest.LOGIN_PAGE);
        }
    }
}
