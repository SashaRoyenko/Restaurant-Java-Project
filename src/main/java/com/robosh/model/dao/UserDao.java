package com.robosh.model.dao;

import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;


public interface UserDao extends Dao<User> {
    boolean isUserExist(String email, String password);
    boolean isEmailTaken(String email);
    boolean isPhoneTaken(String phone);
    User getUserByEmailAndPassword(String email, String password);
    void changeRole(User user, Role role);
}
