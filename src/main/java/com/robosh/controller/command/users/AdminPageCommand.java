package com.robosh.controller.command.users;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.pagination.PaidPagination;
import com.robosh.controller.command.pagination.UncheckPagination;
import com.robosh.controller.utils.PagesPath;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminPageCommand implements Command {

    private OrderService orderService;

    public AdminPageCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        new PaidPagination(orderService).execute(request, response);
        new UncheckPagination(orderService).execute(request, response);
        request.getRequestDispatcher(PagesPath.ADMIN_PAGE).forward(request, response);
    }
}
