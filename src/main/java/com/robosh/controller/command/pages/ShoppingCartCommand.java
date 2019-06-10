package com.robosh.controller.command.pages;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.User;
import com.robosh.service.OrderProductsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShoppingCartCommand implements Command {
    private OrderProductsService orderProductsService;

    public ShoppingCartCommand(OrderProductsService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = SessionUtil.getUserFromSession(request.getSession());
        List<Dish> dishList = orderProductsService.selectDishes(user);
        List<Drink> drinkList = orderProductsService.selectDrinks(user);
        float totalPrice = orderProductsService.getTotalPrice(user);
        request.getSession().setAttribute("userDishes", dishList);
        request.getSession().setAttribute("userDrinks", drinkList);
        request.getSession().setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher(PagesPath.SHOPPING_CART_PAGE).forward(request, response);
    }
}
