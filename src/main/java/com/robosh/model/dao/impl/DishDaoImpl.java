package com.robosh.model.dao.impl;

import com.robosh.model.dao.DishDao;
import com.robosh.model.dao.impl.SqlQueries.DishSqlQueries;
import com.robosh.model.dao.mapper.DishMapper;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDaoImpl implements DishDao {


    private Connection connection;

    public DishDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Dish entity) throws SQLException {
        final String query = DishSqlQueries.CREATE_DISH.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setFloat(2, entity.getPrice());
        preparedStatement.setShort(3, entity.getWeight());
        preparedStatement.execute();
    }

    @Override
    public Dish findById(long id) throws SQLException {
        Dish dish = new Dish();
        DishMapper dishMapper = new DishMapper();
        final String query = DishSqlQueries.FIND_DISH_BY_ID.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
        final ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            dish = dishMapper.extractObjectFromResultSet(resultSet);
        }
        return dish;
    }

    @Override
    public List<Dish> findAll() throws SQLException {
        DishMapper dishMapper = new DishMapper();
        List<Dish> dishList = new ArrayList<>();
        Statement statement = connection.createStatement();
        final String query = DishSqlQueries.FIND_ALL_DISHES.getQuery();
        final ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            dishList.add(dishMapper.extractObjectFromResultSet(resultSet));
        }
        return dishList;
    }

    @Override
    public void update(Dish dish) throws SQLException {

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
    public void addIngredient(long dish_id, long ingredient_id) throws SQLException {
        final String query = DishSqlQueries.ADD_DISH_INGREDIENT.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, dish_id);
        preparedStatement.setLong(2, ingredient_id);
        preparedStatement.execute();
    }

    @Override
    public List<Ingredient> selectDishIngredients(Dish dish) throws SQLException {
        List<Ingredient> ingredientList;
        DishMapper dishMapper = new DishMapper();
        final String query = DishSqlQueries.FIND_DISH_INGREDIENTS.getQuery();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, dish.getId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        ingredientList = dishMapper.extractDishIngredients(resultSet);
        return ingredientList;
    }
}
