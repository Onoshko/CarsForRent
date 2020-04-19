package com.github.web.filter;

import com.github.dao.UserDao;
import com.github.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebFilter("/hello")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDao> dao = (AtomicReference<UserDao>) req.getServletContext().getAttribute("dao");
        HttpSession session = req.getSession();

        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {
            final User.ROLE role = (User.ROLE) session.getAttribute("role");
            moveToMenu(req, resp, role);

        } else if (dao.get().userIsExist(login, password)) {
            final User.ROLE role = dao.get().getRoleByLoginPassword(login, password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("role", role);
            moveToMenu(req, resp, role);

        } else {
            moveToMenu(req, resp, User.ROLE.UNKNOWN);
        }

    }private void moveToMenu(final HttpServletRequest req,final HttpServletResponse res,final User.ROLE role)
            throws ServletException, IOException {

        if (role.equals(User.ROLE.ADMIN)) {
            req.getRequestDispatcher("/admin_menu.jsp").forward(req, res);
        } else if (role.equals(User.ROLE.USER)) {
            req.getRequestDispatcher("/user_menu.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}

