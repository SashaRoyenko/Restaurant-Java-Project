package com.robosh.model.dao.impl;

import com.robosh.model.dao.UserDao;
import com.robosh.model.dao.impl.SqlQueries.UserSqlQueries;
import com.robosh.model.dao.mapper.UserMapper;
import com.robosh.model.entity.User;
import com.robosh.model.entity.enums.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(final User entity) {
        final String query = UserSqlQueries.CREATE_USER.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public User findById(long id) {
        UserMapper userMapper = new UserMapper();
        User user = new User();
        final String query = UserSqlQueries.FIND_USER_BY_ID.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = userMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        UserMapper userMapper = new UserMapper();
        List<User> userList = new ArrayList<>();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            final String query = UserSqlQueries.FIND_ALL_USERS.getQuery();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                userList.add(userMapper.extractObjectFromResultSet(resultSet));
            }
        }
        catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
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
    public boolean isUserExist(final String email, final String password) {
        final String query = UserSqlQueries.FIND_USER_BY_EMAIL_AND_PASSWORD.getQuery();

        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            final ResultSet resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean isEmailTaken(final String email) {
        final String query = UserSqlQueries.FIND_EMAIL.getQuery();
        final ResultSet resultSet;
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean isPhoneTaken(final String phone) {
        final String query = UserSqlQueries.FIND_PHONE.getQuery();
        final ResultSet resultSet;
        boolean result = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phone);
            resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        UserMapper userMapper = new UserMapper();
        User user = new User();
        final String query = UserSqlQueries.FIND_USER_BY_EMAIL_AND_PASSWORD.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = userMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void changeRole(User user, Role role) {
        final String query = UserSqlQueries.UPDATE_USER_ROLE.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, role.toString().toLowerCase());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
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
