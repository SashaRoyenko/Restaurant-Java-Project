package com.robosh.model.dao.mapper;

import com.robosh.model.entity.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientMapper implements Mapper<Ingredient> {
    @Override
    public Ingredient extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        return new Ingredient(
                resultSet.getLong("ingredient_id"),
                resultSet.getString("ingredient_name"));
    }
}
