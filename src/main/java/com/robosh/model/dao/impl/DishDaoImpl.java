package com.robosh.model.dao.impl;

import com.robosh.model.dao.DishDao;
import com.robosh.model.dao.impl.SqlQueries.DishSqlQueries;
import com.robosh.model.dao.mapper.DishMapper;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Ingredient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {


    private Connection connection;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    public DishDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Dish entity) {
        final String query = DishSqlQueries.CREATE_DISH.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setFloat(2, entity.getPrice());
            preparedStatement.setShort(3, entity.getWeight());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public Dish findById(long id){
        Dish dish = new Dish();
        DishMapper dishMapper = new DishMapper();
        final String query = DishSqlQueries.FIND_DISH_BY_ID.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                dish = dishMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return dish;
    }

    @Override
    public List<Dish> findAll(){
        DishMapper dishMapper = new DishMapper();
        List<Dish> dishList = new ArrayList<>();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            final String query = DishSqlQueries.FIND_ALL_DISHES.getQuery();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                dishList.add(dishMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return dishList;
    }

    @Override
    public void update(Dish dish) throws SQLException {
        throw new UnsupportedOperationException("This action has not been used here.");
    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = DishSqlQueries.DELETE_DISH.getQuery();
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
    public void addIngredient(long dish_id, long ingredient_id){
        final String query = DishSqlQueries.ADD_DISH_INGREDIENT.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, dish_id);
            preparedStatement.setLong(2, ingredient_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> selectDishIngredients(Dish dish) {
        List<Ingredient> ingredientList = null;
        DishMapper dishMapper = new DishMapper();
        final String query = DishSqlQueries.FIND_DISH_INGREDIENTS.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, dish.getId());
            resultSet = preparedStatement.executeQuery();
            ingredientList = dishMapper.extractDishIngredients(resultSet);
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at UserDaoImpl ", e);
            e.printStackTrace();
        }
        return ingredientList;
    }
}
