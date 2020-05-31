package com.github.Onoshko.dao.impl;

import com.github.Onoshko.dao.AuthUserDao;
import com.github.Onoshko.dao.DataSource;
import com.github.Onoshko.model.AuthUser;
import com.github.Onoshko.model.Role;
import com.github.Onoshko.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultAuthUserDao implements AuthUserDao {

    private static class SingletonHolder {
        static final AuthUserDao HOLDER_INSTANCE = new DefaultAuthUserDao();
    }

    public static AuthUserDao getInstance() {
        return DefaultAuthUserDao.SingletonHolder.HOLDER_INSTANCE;
    }

    @Override
    public AuthUser getByLogin(String login) {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from auth_user where login = ?")) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new AuthUser(
                            rs.getLong("id"),
                            rs.getString("login"),
                            rs.getString("password"),
                            Role.valueOf(rs.getString("role")),
                            rs.getLong("userid"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long addAuthUser(AuthUser user) {
        final String sql = "insert into auth_user(login, password, role, userid) values(?,?,?,?)";
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole().name());
            ps.setLong(4, user.getUserId());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return keys.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<AuthUser> getAllAuthUsers() {
        try (Connection connection = DataSource.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from auth_user");
             ResultSet rs = ps.executeQuery()) {
            final ArrayList<AuthUser> users = new ArrayList<>();
            while (rs.next()) {
                AuthUser user = new AuthUser(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role")),
                        rs.getLong("userid"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}