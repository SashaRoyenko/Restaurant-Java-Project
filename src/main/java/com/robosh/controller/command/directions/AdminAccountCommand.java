package com.robosh.controller.command.directions;

import com.robosh.controller.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminAccountCommand implements Command {
    private OrderService orderService;

    public AdminAccountCommand(OrderService orderService) {
        this.orderService = orderService;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Order> orderList = orderService.getAllOrders();
        System.out.println(orderList);
        request.setAttribute("orderList", orderList);
        return "/jsp/account/adminAccount.jsp";
    }
}
