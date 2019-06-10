package com.robosh.controller.command.users;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderProductsService;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserPageCommand implements Command {
    private OrderService orderService;

    public UserPageCommand(OrderService orderService) {
        this.orderService = orderService;
    }
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Order> unPaidOrders = orderService.getUserUnpaidOrders(SessionUtil.getUserFromSession(request.getSession()).getId());
        request.setAttribute("unPaidOrders", unPaidOrders);
        request.getRequestDispatcher(PagesPath.USER_PAGE).forward(request, response);
    }
}

