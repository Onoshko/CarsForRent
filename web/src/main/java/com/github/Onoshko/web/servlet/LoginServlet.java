package com.github.Onoshko.web.servlet;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.Role;
import com.github.Onoshko.service.SecurityService;
import com.github.Onoshko.service.impl.DefaultSecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private SecurityService securityService = DefaultSecurityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Object authUser = rq.getSession().getAttribute("authUser");
        if (authUser == null) {
            rq.getRequestDispatcher("/login.jsp").forward(rq, rs);
            return;
        }
        //rq.getRequestDispatcher("/user_menu.jsp").forward(rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String login = rq.getParameter("login");
        String password = rq.getParameter("password");

        AuthUser user = securityService.login(login, password);
        if (user == null) {
            rq.setAttribute("error", "login or password invalid");
            rq.getRequestDispatcher("/login.jsp").forward(rq, rs);
            return;
        } else if (user.getRole()== Role.ADMIN) {
            rq.getSession().setAttribute("authUser", user);
            rq.getRequestDispatcher("/admin_menu.jsp").forward(rq, rs);
            return;

        } else if (user.getRole()==Role.USER) {
            rq.getSession().setAttribute("authUser", user);
            rq.getRequestDispatcher("/user_menu.jsp").forward(rq, rs);
            return;


        }
    }
}





