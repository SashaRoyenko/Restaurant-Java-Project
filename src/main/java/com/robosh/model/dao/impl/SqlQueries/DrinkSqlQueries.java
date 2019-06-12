package com.robosh.model.dao.impl.SqlQueries;

public enum DrinkSqlQueries {
    CREATE_DRINK("INSERT INTO drink(drink_name, drink_volume, drink_price) values((?),(?),(?));"),
    FIND_DRINK_BY_ID("SELECT * FROM drink WHERE drink_id = (?)"),
    FIND_ALL_DRINKS("SELECT * FROM drink"),
    DELETE_DRINK("DELETE FROM  drink WHERE (drink_id = (?))");
    String query;

    DrinkSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
