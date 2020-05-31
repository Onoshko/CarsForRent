package com.github.Onoshko.web.servlet;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.Role;
import com.github.Onoshko.service.SecurityService;
import com.github.Onoshko.service.impl.DefaultSecurityService;
import com.github.Onoshko.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)  {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtils.forward("login", rq, rs);
            return;
        }
        WebUtils.redirect("/login", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)  {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");
        AuthUser user = securityService.login(login, password);
        if (user == null) {
            rq.setAttribute("error", "login or password invalid");
            log.info("user {} logged", user.getLogin());
            WebUtils.forward("login", rq, rs);
            return;
        } else if (user.getRole()== Role.ADMIN) {
            rq.getSession().setAttribute("authUser", user);
            log.info("user {} logged", user.getLogin());
            WebUtils.redirect("/admin_menu", rq, rs);

        } else if (user.getRole()==Role.USER) {
            rq.getSession().setAttribute("authUser", user);
            log.info("user {} logged", user.getLogin());
            WebUtils.forward("user_menu", rq, rs);
            return;


        }
    }
}





