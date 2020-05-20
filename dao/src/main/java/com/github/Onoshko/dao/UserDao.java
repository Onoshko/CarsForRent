package com.github.Onoshko.dao;

import com.github.Onoshko.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    Long addUser(User user);
    void deleteUser(Long Id);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(Long Id);

}

