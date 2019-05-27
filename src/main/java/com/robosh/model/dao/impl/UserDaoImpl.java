package com.robosh.model.dao.impl;

import com.robosh.model.dao.UserDao;
import com.robosh.model.dao.impl.SqlQueries.UserSqlQueries;
import com.robosh.model.dao.mapper.UserMapper;
import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(final User entity) throws SQLException {
        final String query = UserSqlQueries.CREATE_USER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getPhone());
        preparedStatement.setString(4, entity.getEmail());
        preparedStatement.setString(5, entity.getPassword());
        preparedStatement.execute();
    }

    @Override
    public User findById(long id) throws SQLException {
        UserMapper userMapper = new UserMapper();
        User user = new User();
        final String query = UserSqlQueries.FIND_USER_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
        final ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            user = userMapper.extractObjectFromResultSet(resultSet);
        }

        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        UserMapper userMapper = new UserMapper();
        List<User> userList = new ArrayList<>();
        Statement statement = connection.createStatement();
        final String query = UserSqlQueries.FIND_ALL_USERS.getQuery();
        final ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            userList.add(userMapper.extractObjectFromResultSet(resultSet));
        }
        return userList;
    }

    @Override
    public void update(User user) throws SQLException {
        throw new UnsupportedOperationException("This action has not been used here.");
    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = UserSqlQueries.DELETE_USER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
    }

    @Override
    public boolean isUserExist(final String email, final String password) throws SQLException {
        final String query = UserSqlQueries.FIND_USER_BY_EMAIL_AND_PASSWORD.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        final ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public boolean isEmailTaken(final String email) throws SQLException {
        final String query = UserSqlQueries.FIND_EMAIL.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        final ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public boolean isPhoneTaken(final String phone) throws SQLException {
        final String query = UserSqlQueries.FIND_PHONE.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, phone);
        final ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    @Override
    public void changeRole(User user, Role role) throws SQLException {
        final String query = UserSqlQueries.UPDATE_USER_ROLE.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, role.toString().toLowerCase());
        preparedStatement.setLong(2, user.getId());
        preparedStatement.executeQuery();
    }


    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
