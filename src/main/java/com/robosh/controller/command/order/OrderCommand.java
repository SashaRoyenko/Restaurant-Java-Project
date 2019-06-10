package com.robosh.controller.command.order;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.pages.ShoppingCartCommand;
import com.robosh.controller.command.users.AdminPageCommand;
import com.robosh.controller.command.users.UserPageCommand;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderProductsService;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderCommand implements Command {
    private OrderService orderService;

    public OrderCommand(OrderService orderService) {
        this.orderService = orderService;
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
        long id = Long.parseLong(request.getParameter("id"));

        switch (action){
            case CONFIRM_ACTION:
                orderService.confirmOrder(id);
                adminPage.execute(request, response);
                break;
            case CREATE_ORDER_ACTION:
                Order order = Order.newBuilder()
                              .setAddress("")
                                .setUser(SessionUtil.getUserFromSession(request.getSession()))
                                .build();
                orderService.createOrder(order);
                shoppingCart.execute(request, response);
                break;
            case PAY_ORDER_ACTION:
                orderService.changePaymentStatus(id);
                userPage.execute(request, response);
                break;
        }
    }


}
