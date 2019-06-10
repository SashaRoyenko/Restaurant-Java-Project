package com.robosh.controller.command.pagination;

import com.robosh.controller.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UncheckPagination implements Command {
    private OrderService orderService;

    public UncheckPagination(OrderService orderService) {
        this.orderService = orderService;
    }
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final long recordsPerPage = 5L;
        long currentPage;
        if (request.getParameter("currentUnCheckPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentUnCheckPage"));
        } else {
            currentPage = 1;
        }
        List<Order> uncheckedOrders = orderService.getUncheckedOrders(currentPage-1, recordsPerPage);
        request.setAttribute("uncheckedOrders", uncheckedOrders);

        long rows = orderService.getPaidOrderCount();

        long nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("numberOFUnCheckPages", nOfPages);
        request.setAttribute("currentUnCheckPage", currentPage);
    }
}
