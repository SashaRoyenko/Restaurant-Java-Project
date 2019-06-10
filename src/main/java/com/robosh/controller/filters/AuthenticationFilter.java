package com.robosh.controller.filters;

import com.robosh.controller.command.errors.Error403Command;
import com.robosh.controller.command.pages.HomeCommand;
import com.robosh.controller.command.users.AdminPageCommand;
import com.robosh.controller.command.users.UserPageCommand;
import com.robosh.controller.utils.PagesRequest;
import com.robosh.controller.utils.SecurityUtil;
import com.robosh.controller.utils.SessionUtil;
import com.robosh.model.entity.User;
import com.robosh.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String pathInfo = request.getPathInfo();
        User loggedUser = SessionUtil.getUserFromSession(request.getSession());

        if (PagesRequest.LOGIN.equals(pathInfo) && loggedUser != null) {
            forwardUser(loggedUser, request, response);
            return;
        }

        if (SecurityUtil.isSecurityPage(request)) {
            if (loggedUser != null && SecurityUtil.hasPermission(request, loggedUser.getRole())) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                new Error403Command().execute(request, response);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private void forwardUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        switch (user.getRole()) {
            case ADMIN:
                response.sendRedirect(PagesRequest.PATH + PagesRequest.ADMIN_PAGE);
                break;
            case USER:
                response.sendRedirect(PagesRequest.PATH + PagesRequest.USER_PAGE);
                break;
            default:
                System.out.println("default");
               response.sendRedirect(PagesRequest.PATH + PagesRequest.HOME_PAGE);
        }
    }

    @Override
    public void destroy() {

    }
}
