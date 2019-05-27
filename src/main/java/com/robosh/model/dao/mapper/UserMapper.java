package com.robosh.model.dao.mapper;

import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        User user = User.newBuilder()
                .setId(resultSet.getLong("user_id"))
                .setFirstName(resultSet.getString("first_name"))
                .setLastName(resultSet.getString("last_name"))
                .setPhone(resultSet.getString("phone"))
                .setEmail(resultSet.getString("email"))
                .setPassword(resultSet.getString("password"))
                .setRole(Role.valueOf(resultSet.getString("role").toUpperCase()))
                .build();
        return user;
    }
}
