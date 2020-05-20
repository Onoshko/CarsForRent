package com.github.Onoshko.service.impl;

import com.github.Onoshko.dao.impl.DefaultAuthUserDao;
import com.github.Onoshko.dao.impl.DefaultUserDao;
import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.User;
import com.github.Onoshko.service.RegistrationService;

public class DefaultRegistrationService implements RegistrationService {



    private static class SingletonHolder {
        static final RegistrationService HOLDER_INSTANCE = new DefaultRegistrationService();
    }
    public static RegistrationService getInstance(){return DefaultRegistrationService.SingletonHolder.HOLDER_INSTANCE;}

    @Override
    public Long saveUser(User user) {
        return DefaultUserDao.getInstance().addUser(user);
    }

    @Override
    public Long saveAuthUser(AuthUser user) {
        return DefaultAuthUserDao.getInstance().addAuthUser(user);
    }
}

