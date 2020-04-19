package com.github.web;

import com.github.dao.UserDao;
import com.github.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.model.User.ROLE.ADMIN;
import static com.github.model.User.ROLE.USER;

@WebListener
public class Listener implements ServletContextListener {
    private AtomicReference<UserDao> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        dao = new AtomicReference<>(new UserDao());
        dao.get().add(new  User(1,"Nick","1", ADMIN));
        dao.get().add((new  User(2,"Jack","1", USER)));

        final ServletContext servletContext=servletContextEvent.getServletContext();

        servletContext.setAttribute("dao",dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        dao = null;
    }
}
