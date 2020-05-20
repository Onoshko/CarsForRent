package com.github.Onoshko.service;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.User;

public interface RegistrationService {

    Long saveUser(User user);
    Long saveAuthUser(AuthUser authUser);

}
