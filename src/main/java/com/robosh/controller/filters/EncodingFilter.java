package com.robosh.controller.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * This filter is used to set encoding type in app
 * @author Sasha
 */
public class EncodingFilter implements Filter {

    private static final String ENCODING_TYPE = "encoding_type";
    private String encodingTypeValue;
    private static final Logger LOGGER = Logger.getLogger(EncodingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        encodingTypeValue = filterConfig.
                getInitParameter(ENCODING_TYPE);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.debug("Set encoding type " + encodingTypeValue);
        servletRequest.setCharacterEncoding(encodingTypeValue);
        servletResponse.setCharacterEncoding(encodingTypeValue);
        servletResponse.setContentType("text/html; charset=" + encodingTypeValue);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
