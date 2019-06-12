package com.robosh.controller.command.pagination;

import com.robosh.controller.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class PaidPagination implements Command {
    Logger logger = LogManager.getLogger(PaidPagination.class);
    private OrderService orderService;

    public PaidPagination(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final long recordsPerPage = 5L;
        long currentPage;
        if (request.getParameter("currentPaidPage") != null) {
            currentPage = Integer.parseInt(request.getParameter("currentPaidPage"));
        } else {
            currentPage = 1;
        }
        List<Order> paidOrders = orderService.getPaidOrders(((currentPage - 1) * recordsPerPage), recordsPerPage * currentPage);

        request.setAttribute("paidOrders", paidOrders);

        long rows = orderService.getPaidOrderCount();

        long nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        logger.info("Paid pagination:");
        logger.info("\tCurrent page: " + currentPage);
        logger.info("\tNumber of pages: " + nOfPages);

        request.setAttribute("numberOfPaidPages", nOfPages);
        request.setAttribute("currentPaidPage", currentPage);
    }
}
