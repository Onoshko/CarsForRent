package com.github.Onoshko.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse)servletResponse;
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            rq.getRequestDispatcher("/login.jsp").forward(rq, rs);
            return;
        }
        filterChain.doFilter(rq, servletResponse);
    }
}

