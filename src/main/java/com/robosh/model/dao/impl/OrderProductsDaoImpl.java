package com.robosh.model.dao.impl;

import com.robosh.model.dao.OrderProductsDao;
import com.robosh.model.dao.impl.SqlQueries.OrderProductsQueries;
import com.robosh.model.dao.mapper.OrderProductsMapper;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.model.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProductsDaoImpl implements OrderProductsDao {
    private Connection connection;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public OrderProductsDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createOrderProductsWithUser(User user) {
        final String query = OrderProductsQueries.CREATE_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public void create(OrderProducts entity) {
        final String query = OrderProductsQueries.CREATE_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, entity.getUser().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }


    @Override
    public OrderProducts findOrderProductsByUser(User user) {
        OrderProducts orderProducts = new OrderProducts();
        String query = OrderProductsQueries.FIND_ORDER_PRODUCTS_BY_USER.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               orderProducts.setId(resultSet.getLong("order_products_id"));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
        return orderProducts;
    }

    @Override
    public OrderProducts findById(long id) {
        OrderProducts orderProducts = new OrderProducts();
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        String query = OrderProductsQueries.FIND_ORDER_PRODUCTS_BY_ID.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                orderProducts = orderProductsMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
        return orderProducts;
    }

    @Override
    public List<OrderProducts> findAll() {
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        List<OrderProducts> orderProducts = new ArrayList<>();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            final String query = OrderProductsQueries.FIND_ALL_ORDER_PRODUCTS.getQuery();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                orderProducts.add(orderProductsMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
        return orderProducts;
    }

    @Override
    public void update(OrderProducts orderProducts) throws SQLException {

    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = OrderProductsQueries.DELETE_ORDER_PRODUCTS.getQuery();
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
    public void addDish(Dish dish, OrderProducts orderProducts) {
        final String query = OrderProductsQueries.ADD_DISH_TO_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, dish.getId());
            preparedStatement.setLong(2, orderProducts.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public void addDrink(Drink drink, OrderProducts orderProducts) {
        final String query = OrderProductsQueries.ADD_DRINK_TO_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, drink.getId());
            preparedStatement.setLong(2, orderProducts.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDish(Dish dish, OrderProducts orderProducts) {
        final String query = OrderProductsQueries.DELETE_DISH_FROM_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, dish.getId());
            preparedStatement.setLong(2, orderProducts.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDrink(Drink drink, OrderProducts orderProducts) {
        final String query = OrderProductsQueries.DELETE_DRINK_FROM_ORDER_PRODUCTS.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, drink.getId());
            preparedStatement.setLong(2, orderProducts.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public float getTotalDishPrice(User user) {
        float result = 0;
        final String query = OrderProductsQueries.GET_TOTAL_DISH_PRICE.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getFloat("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public float getTotalDrinkPrice(User user) {
        float result = 0;
        final String query = OrderProductsQueries.GET_TOTAL_DRINK_PRICE.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getFloat("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Drink> selectDrinks(User user) {
        List<Drink> drinkList = null;
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        final String query = OrderProductsQueries.SELECT_DRINKS_FROM_ORDER_PRODUCTS.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            drinkList = orderProductsMapper.extractOrderProductsDrinks(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinkList;
    }

    @Override
    public List<Dish> selectDishes(User user) {
        List<Dish> dishList = null;
        OrderProductsMapper orderProductsMapper = new OrderProductsMapper();
        final String query = OrderProductsQueries.SELECT_DISHES_FROM_ORDER_PRODUCTS.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, user.getId());
            resultSet = preparedStatement.executeQuery();
            dishList = orderProductsMapper.extractOrderProductsDishes(resultSet);
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at OrderProductsDaoImpl ", e);
            e.printStackTrace();
        }
        return dishList;
    }


}
