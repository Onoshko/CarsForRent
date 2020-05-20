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
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/admin_menu")
public class AdminServlet extends HttpServlet {
    private UserService userService = DefaultUserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        List<User> users = userService.getUser();
        rq.setAttribute("users", users);
        rq.getRequestDispatcher("/admin_menu.jsp").forward(rq, rs);
    }
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String firstName = rq.getParameter("firstName");
        String lastName = rq.getParameter("lastName");
        String phone = rq.getParameter("phone");
        String email = rq.getParameter("email");
       // Long id = userService.saveStudent(new User(null, firstName, lastName, phone, email));


        rq.getRequestDispatcher("/admin_menu.jsp").forward(rq, rs);;
    }
}
