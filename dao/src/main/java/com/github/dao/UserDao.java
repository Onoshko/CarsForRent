package com.github.dao;

import com.github.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final List<User> users=new ArrayList<>();

    //получение пользователя по по id

    public User getByud(int id){
        User user1=new User();
        user1.setId(-1);

        for (User user: users) {
            if (user.getId()== id){
                user1=user;
            }
        }
        return user1;
    }

    //получение пользователя через логин и пароль
    public User getUserByLoginPassword(final String login, final String password){
        User user1=new User();
        user1.setId(-1);

        for (User user:users){
            if (user.getLogin().equals(login)&& user.getPassword().equals(password)){
                user1= user;
            }
        }
        return user1;
    }

    //добавление пользователя
    public boolean add(final User user) {

        for (User u : users) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }
        return users.add(user);
    }

    //получение роли по паре логин и пароль

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE user1 = User.ROLE.UNKNOWN;

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                user1 = user.getRole();
            }
        }
        return user1;
    }

    //проверяем существует ли пользователь с таким логином и паролем

    public boolean userIsExist(final String login, final String password) {
        boolean user1 = false;

        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                user1 = true;
                break;
            }
        }
        return user1;
    }
}
