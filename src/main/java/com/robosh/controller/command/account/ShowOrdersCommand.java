package com.robosh.controller.command.account;

import com.robosh.controller.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowOrdersCommand implements Command {
    private OrderService orderService;

    public ShowOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orderList = orderService.getAllOrders();
        System.out.println(orderList);
        request.setAttribute("orderList", orderList);
        return "/jsp/showOrders.jsp";
    }
}
