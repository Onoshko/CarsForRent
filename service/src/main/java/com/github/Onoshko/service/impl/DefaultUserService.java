package com.github.Onoshko.service.impl;

import com.github.Onoshko.dao.impl.DefaultUserDao;
import com.github.Onoshko.model.User;
import com.github.Onoshko.service.UserService;

import java.util.List;

public class DefaultUserService implements UserService {

    private static class SingletonHolder {
        static final UserService HOLDER_INSTANCE = new DefaultUserService();
    }
    public static UserService getInstance() {
        return DefaultUserService.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public List<User> getUser() {return DefaultUserDao.getInstance().getAllUsers();}



}
