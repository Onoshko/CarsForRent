package com.github.Onoshko.service.impl;

import com.github.Onoshko.dao.impl.DefaultAuthUserDao;
import com.github.Onoshko.dao.impl.DefaultUserDao;
import com.github.Onoshko.model.AuthUser;
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
    public List<User> getAllUsers() {return DefaultUserDao.getInstance().getAllUsers();}

    @Override
    public Long saveUser(User user) {
        return DefaultUserDao.getInstance().addUser(user);
    }

    @Override
    public void deleteUser(Long Id) {DefaultUserDao.getInstance().deleteUser(Id);

    }

    @Override
    public Long updateUser(User user) {return DefaultUserDao.getInstance().updateUser(user);

    }

    @Override
    public List<AuthUser> getAllAuthUsers() {return DefaultAuthUserDao.getInstance().getAllAuthUsers();

    }
}
