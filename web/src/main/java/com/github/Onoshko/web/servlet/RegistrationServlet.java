package com.github.Onoshko.web.servlet;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.Role;
import com.github.Onoshko.model.User;
import com.github.Onoshko.service.RegistrationService;
import com.github.Onoshko.service.impl.DefaultRegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private RegistrationService registrationService = DefaultRegistrationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String cardNumber = req.getParameter("cardNumber");
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        Long id = registrationService.saveUser(new User(null,firstName, lastName, phone, email,cardNumber));
        Long id1 = registrationService.saveAuthUser(new AuthUser(null,login, password, Role.USER ,id ));
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

}
