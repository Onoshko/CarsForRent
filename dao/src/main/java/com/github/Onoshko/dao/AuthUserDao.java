package com.github.Onoshko.dao;

import com.github.Onoshko.model.AuthUser;

public interface AuthUserDao {
    AuthUser getByLogin(String login);

    Long addAuthUser(AuthUser user);
}

