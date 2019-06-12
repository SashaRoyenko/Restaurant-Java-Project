package com.robosh.controller.command.users;

import com.robosh.controller.command.Command;
import com.robosh.controller.command.pagination.PaidPagination;
import com.robosh.controller.command.pagination.UncheckPagination;
import com.robosh.controller.utils.PagesPath;
import com.robosh.service.OrderService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminPageCommand implements Command {
    private Logger logger = LogManager.getLogger(AdminPageCommand.class);

    private OrderService orderService;

    public AdminPageCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        new PaidPagination(orderService).execute(request, response);
        new UncheckPagination(orderService).execute(request, response);
        logger.info("Forward to admin page");
        request.getRequestDispatcher(PagesPath.ADMIN_PAGE).forward(request, response);
    }
}
