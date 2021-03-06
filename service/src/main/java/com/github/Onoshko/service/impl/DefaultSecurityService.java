package com.github.Onoshko.service.impl;

import com.github.Onoshko.dao.AuthUserDao;
import com.github.Onoshko.dao.impl.DefaultAuthUserDao;
import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.service.SecurityService;

public class DefaultSecurityService implements SecurityService {
    private static class SingletonHolder {
        static final SecurityService HOLDER_INSTANCE = new DefaultSecurityService();
    }

    public static SecurityService getInstance() {
        return DefaultSecurityService.SingletonHolder.HOLDER_INSTANCE;
    }

    private AuthUserDao authUserDao = DefaultAuthUserDao.getInstance();

    public AuthUser login(String login, String password) {
        AuthUser user = authUserDao.getByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}
