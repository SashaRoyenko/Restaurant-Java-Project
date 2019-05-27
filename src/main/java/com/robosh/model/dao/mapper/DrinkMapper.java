package com.robosh.model.dao.mapper;

import com.robosh.model.entity.Drink;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrinkMapper implements Mapper<Drink> {

    @Override
    public Drink extractObjectFromResultSet(ResultSet resultSet) throws SQLException {
        Drink drink = Drink.newBuilder()
                .setId(resultSet.getLong("drink_id"))
                .setName(resultSet.getString("drink_name"))
                .setPrice(resultSet.getFloat("drink_price"))
                .setVolume(resultSet.getFloat("drink_volume"))
                .build();
        return drink;
    }
}
