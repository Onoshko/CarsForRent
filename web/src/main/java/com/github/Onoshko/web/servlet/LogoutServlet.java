package com.github.Onoshko.web.servlet;

import com.github.Onoshko.service.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private SecurityService securityService;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        rq.getSession().removeAttribute("authUser");
        rq.getSession().invalidate();
        rq.getRequestDispatcher("/login").forward(rq, rs);
    }

}
