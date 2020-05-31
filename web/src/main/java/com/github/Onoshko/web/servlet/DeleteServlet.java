package com.github.Onoshko.web.servlet;

import com.github.Onoshko.model.User;
import com.github.Onoshko.service.UserService;
import com.github.Onoshko.service.impl.DefaultUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private UserService userService = DefaultUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        Long id = Long.valueOf(rq.getParameter("Id"));
        userService.deleteUser(id);
        rq.getRequestDispatcher("/admin_menu.jsp").forward(rq, rs);

    }
}


