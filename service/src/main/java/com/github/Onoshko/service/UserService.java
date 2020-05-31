package com.github.Onoshko.service;

import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Long saveUser(User user);
    void deleteUser(Long Id);
    Long updateUser(User user);
    List<AuthUser> getAllAuthUsers();

}
