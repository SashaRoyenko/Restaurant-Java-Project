package com.robosh.controller.command.order;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.pages.ShoppingCartCommand;
import com.robosh.controller.command.users.AdminPageCommand;
import com.robosh.controller.command.users.UserPageCommand;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Order;
import com.robosh.model.entity.User;
import com.robosh.service.OrderProductsService;
import com.robosh.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderCommand implements Command {
    private final Logger logger = LogManager.getLogger(OrderCommand.class);
    private OrderService orderService;
    private OrderProductsService orderProductsService;

    public OrderCommand(OrderService orderService, OrderProductsService orderProductsService) {
        this.orderService = orderService;
        this.orderProductsService = orderProductsService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminPageCommand adminPage = new AdminPageCommand(new OrderService());
        UserPageCommand userPage = new UserPageCommand(new OrderService());
        ShoppingCartCommand shoppingCart = new ShoppingCartCommand(new OrderProductsService());
        String action = request.getParameter("action");
        final String CONFIRM_ACTION = "confirmOrder";
        final String CREATE_ORDER_ACTION = "buy";
        final String PAY_ORDER_ACTION = "payOrder";
        long id = 0;
        if(request.getParameter("id") != null) {
            logger.info("Get parameter id: " + id);
            id = Long.parseLong(request.getParameter("id"));
        }
        switch (action) {
            case CONFIRM_ACTION:
                orderService.confirmOrder(id);
                logger.info("Confirm order");
                adminPage.execute(request, response);
                break;
            case CREATE_ORDER_ACTION:
                User user = SessionUtil.getUserFromSession(request.getSession());
                final String address = request.getParameter("address");
                Order order = Order.newBuilder()
                        .setAddress(address)
                        .setUser(user)
                        .build();
                orderService.createOrder(order);
                logger.info("Created order");
                orderProductsService.deleteOrderProductsForUserId(user.getId());
                logger.info("Deleted order products");
                shoppingCart.execute(request, response);
                break;
            case PAY_ORDER_ACTION:
                orderService.changePaymentStatus(id);
                logger.info("Order is paid");
                userPage.execute(request, response);
                break;
            default:
                logger.fatal("Default action. Execute shopping card command");
                shoppingCart.execute(request, response);
        }
    }


}
