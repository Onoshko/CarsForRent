package com.github.Onoshko.dao;

import com.github.Onoshko.model.User;

import java.util.List;

public interface UserDao {
    Long addUser(User user);
    void deleteUser(Long Id);
    Long updateUser(User user);
    List<User> getAllUsers();
    User getUserById(Long Id);

}