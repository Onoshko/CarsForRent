package com.github.Onoshko.dao;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.User;

import java.util.List;

public interface AuthUserDao {
    AuthUser getByLogin(String login);

    Long addAuthUser(AuthUser user);

    List<AuthUser> getAllAuthUsers();
}
