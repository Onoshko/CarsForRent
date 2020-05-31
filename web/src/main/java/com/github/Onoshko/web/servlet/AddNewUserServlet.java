package com.github.Onoshko.web.servlet;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.Role;
import com.github.Onoshko.model.User;
import com.github.Onoshko.service.RegistrationService;
import com.github.Onoshko.service.impl.DefaultRegistrationService;
import com.github.Onoshko.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@WebServlet("/addUser")
public class AddNewUserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AddNewUserServlet.class);
    private RegistrationService registrationService = DefaultRegistrationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)  {
        WebUtils.forward("registration", rq, rs);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String cardNumber = req.getParameter("cardNumber");
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        Long id = registrationService.saveUser(new User(null, firstName, lastName, phone, email, cardNumber));
        Long id1 = registrationService.saveAuthUser(new AuthUser(null,login, password, Role.USER ,id ));
        log.info("user created:{} at {}", id, LocalDateTime.now());
        WebUtils.redirect("/admin_menu", req, resp);
    }

}

