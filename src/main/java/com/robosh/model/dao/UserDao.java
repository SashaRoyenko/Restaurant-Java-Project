package com.robosh.model.dao;

import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;

import java.sql.SQLException;

public interface UserDao extends Dao<User> {
    boolean isUserExist(String email, String password) throws SQLException;
    boolean isEmailTaken(String email) throws SQLException;
    boolean isPhoneTaken(String phone) throws SQLException;
    void changeRole(User user, Role role) throws SQLException;
}
