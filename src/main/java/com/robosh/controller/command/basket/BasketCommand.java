package com.robosh.controller.command.basket;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;
import com.robosh.service.DishService;
import com.robosh.service.DrinkService;
import com.robosh.service.OrderProductsService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BasketCommand implements Command {
    private final Logger logger = LogManager.getLogger(BasketCommand.class);
    private DishService dishService;
    private DrinkService drinkService;
    private OrderProductsService orderProductsService;

    public BasketCommand(DishService dishService, DrinkService drinkService, OrderProductsService orderProductsService) {
        this.dishService = dishService;
        this.drinkService = drinkService;
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        final String ADD_DISH = "addDish";
        final String ADD_DRINK = "addDrink";
        final String DELETE_DISH = "deleteDish";
        final String DELETE_DRINK = "deleteDrink";

        User user = SessionUtil.getUserFromSession(request.getSession());
        if (user != null) {
            if (!orderProductsService.isOrderProductsExist(user.getId())) {
                orderProductsService.createOrderProductsWithUSer(user);
                logger.info("Created order products for user");
            }
            OrderProducts orderProducts = orderProductsService.getOrderProductsByUser(user);
            Drink drink = new Drink();
            Dish dish = new Dish();
            long id = 0;
            if (request.getParameter("id") != null) {
                id = Long.parseLong(request.getParameter("id"));
                logger.info("Receive parameter id: " + id);
            }
            switch (action) {
                case ADD_DISH:
                    dish = dishService.getDishById(id);
                    orderProductsService.addDish(dish, orderProducts);
                    logger.info("Add dish");
                    sendRedirect(action, request, response);
                    break;
                case ADD_DRINK:
                    drink = drinkService.getDrinkById(id);
                    orderProductsService.addDrink(drink, orderProducts);
                    sendRedirect(action, request, response);
                    logger.info("Add drink");
                    break;
                case DELETE_DISH:
                    dish = dishService.getDishById(id);
                    orderProductsService.deleteDish(dish, orderProducts);
                    sendRedirect(action, request, response);
                    logger.info("Delete dish");
                    break;
                case DELETE_DRINK:
                    drink = drinkService.getDrinkById(id);
                    orderProductsService.deleteDrink(drink, orderProducts);
                    sendRedirect(action, request, response);
                    logger.info("Delete drink");
                    break;
                default:
                    sendRedirect(action, request, response);
            }
        } else {
            logger.info("User is not authorise - redirect to login");
            response.sendRedirect(PagesRequest.PATH + PagesRequest.LOGIN_PAGE);
        }
    }

    private void sendRedirect(String action, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (action.contains("delete")) {

            response.sendRedirect(PagesRequest.PATH + PagesRequest.SHOPPING_CART_PAGE);
        } else if (action.contains("add")) {
            response.sendRedirect(PagesRequest.PATH + PagesRequest.MENU_PAGE);
        } else {
            response.sendRedirect(PagesRequest.PATH + PagesRequest.LOGIN_PAGE);
        }
    }
}
