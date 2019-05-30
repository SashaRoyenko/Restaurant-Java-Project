package com.robosh.controller.filters;

import com.robosh.controller.command.utils.AppUtils;
import com.robosh.controller.command.utils.SecurityUtils;
import com.robosh.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthentificationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        String pathInfo = request.getPathInfo();
        User loggedUser = AppUtils.getLoggedUser(request.getSession());

        if ("/login5".equals(pathInfo) && loggedUser != null){
            response.sendRedirect(request.getContextPath() + "/tasty-restaurant/" +
                    loggedUser.getRole().toString().toLowerCase() + "Account");
            return;
        }

        if (SecurityUtils.isSecurityPage(request)){
            if (loggedUser != null && SecurityUtils.hasPermission(request, loggedUser.getRole())){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                response.sendRedirect(request.getContextPath() + "/403");
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
