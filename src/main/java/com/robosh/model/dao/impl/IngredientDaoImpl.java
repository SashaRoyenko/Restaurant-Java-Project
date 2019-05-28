package com.robosh.model.dao.impl;

import com.robosh.model.dao.IngredientDao;
import com.robosh.model.dao.impl.SqlQueries.IngredientSqlQueries;
import com.robosh.model.dao.mapper.IngredientMapper;
import com.robosh.model.entity.Ingredient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {
    private Connection connection;
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);


    public IngredientDaoImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void create(Ingredient entity) {
        final String query = IngredientSqlQueries.CREATE_INGREDIENT.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getIngredientName());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at IngredientDaoImpl ", e);
            e.printStackTrace();
        }
    }

    @Override
    public Ingredient findById(long id){
        IngredientMapper ingredientMapper = new IngredientMapper();
        Ingredient ingredient = new Ingredient();
        final String query = IngredientSqlQueries.FIND_INGREDIENT_BY_ID.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ingredient = ingredientMapper.extractObjectFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at IngredientDaoImpl ", e);
            e.printStackTrace();
        }

        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        IngredientMapper ingredientMapper = new IngredientMapper();
        List<Ingredient> ingredientList = new ArrayList<>();
        final ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            final String query = IngredientSqlQueries.FIND_ALL_INGREDIENTS.getQuery();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ingredientList.add(ingredientMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at IngredientDaoImpl ", e);
            e.printStackTrace();
        }
        return ingredientList;
    }

    @Override
    public void update(Ingredient ingredient) throws SQLException {
        throw new UnsupportedOperationException("This action has not been used here.");
    }

    @Override
    public void delete(long id) throws SQLException {
        final String query = IngredientSqlQueries.DELETE_INGREDIENT.getQuery();
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
    public List<Ingredient> selectDishIngredients(long dish_id) {
        IngredientMapper ingredientMapper = new IngredientMapper();
        List<Ingredient> ingredientList = new ArrayList<>();
        final String query = IngredientSqlQueries.FIND_ALL_DISH_INGREDIENTS.getQuery();
        final ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
            Statement statement = connection.createStatement()){
            preparedStatement.setLong(1, dish_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ingredientList.add(ingredientMapper.extractObjectFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at IngredientDaoImpl ", e);
            e.printStackTrace();
        }
        return ingredientList;
    }

    @Override
    public void addDishIngredient(long dish_id, long ingredient_id) {
        final String query = IngredientSqlQueries.ADD_DISH_INGREDIENT.getQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, dish_id);
            preparedStatement.setLong(2, ingredient_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.fatal("SQLException occurred at IngredientDaoImpl ", e);
            e.printStackTrace();
        }
    }
}
