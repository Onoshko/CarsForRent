package com.github.Onoshko.service;

import com.github.Onoshko.model.AuthUser;

public interface SecurityService {
    AuthUser login(String login, String password);


}
