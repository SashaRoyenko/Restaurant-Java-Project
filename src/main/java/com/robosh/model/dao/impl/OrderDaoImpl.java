package com.robosh.model.dao.impl;

import com.robosh.model.dao.OrderDao;
import com.robosh.model.dao.impl.SqlQueries.OrderSqlQueries;
import com.robosh.model.dao.mapper.OrderMapper;
import com.robosh.model.entity.Order;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Connection connection;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order entity) {
        final String query = OrderSqlQueries.CREATE_ORDER.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getAddress());
            preparedStatement.setLong(2, entity.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public Order findById(long id) {
        OrderMapper orderMapper = new OrderMapper(connection);
        Order order = new Order();
        String query = OrderSqlQueries.FIND_ORDER_BY_ID.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order = orderMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getPaidOrders() {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.SELECT_PAID_ORDERS.getQuery();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getUncheckedOrders() {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.SELECT_UNCONFIRMED_ORDERS.getQuery();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getPaidOrders(long from, long to) {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.SELECT_PAID_ORDERS_LIMIT.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, from);
            preparedStatement.setLong(2, to);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getUncheckedOrders(long from, long to) {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.SELECT_UNCONFIRMED_ORDERS_LIMIT.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, from);
            preparedStatement.setLong(2, to);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> getUserUnpaidOrders(long user_id) {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.SELECT_USER_UNPAID_ORDERS.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> findAll() {
        OrderMapper orderMapper = new OrderMapper(connection);
        List<Order> orders = new ArrayList<>();
        String query = OrderSqlQueries.FIND_ALL_ORDERS.getQuery();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orders.add(orderMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void update(Order order) throws SQLException {
        final String query = OrderSqlQueries.DELETE_ORDER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, order.getId());
        preparedStatement.executeQuery();
    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = OrderSqlQueries.DELETE_ORDER.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
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

    @Override
    public boolean isPaid(Order order) {
        String query = OrderSqlQueries.GET_PAID_STATUS.getQuery();
        final ResultSet resultSet;
        boolean paid = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, order.getId());
            resultSet = preparedStatement.executeQuery();
            paid = resultSet.getBoolean("paid");
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return paid;
    }


    @Override
    public void changePaymentStatus(long id) {
        final String query = OrderSqlQueries.UPDATE_PAID_STATUS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public void confirmOrder(long id) {
        final String query = OrderSqlQueries.UPDATE_CHECK_STATUS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public long paidOrderCount() {
        long count = 0;
        String query = OrderSqlQueries.SELECT_PAID_ORDERS_COUNT.getQuery();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public long uncheckedOrderCount() {
        long count = 0;
        String query = OrderSqlQueries.SELECT_UNCONFIRMED_ORDERS_LIMIT.getQuery();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderDaoImpl ", e);
            e.printStackTrace();
        }
        return count;
    }
}
