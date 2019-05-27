package com.robosh.model.dao.impl.SqlQueries;

public enum IngredientSqlQueries{
    CREATE_INGREDIENT("INSERT INTO ingredient(name) values((?));"),
    FIND_INGREDIENT_BY_ID("SELECT * FROM ingredient WHERE ingredient_id = (?)"),
    FIND_ALL_INGREDIENTS("SELECT * FROM ingredient"),
    DELETE_INGREDIENT("DELETE FROM ingredient WHERE (ingredient_id = (?))"),
    FIND_ALL_DISH_INGREDIENTS("SELECT * FROM dish_ingredients WHERE dish_id = (?)"),
    ADD_DISH_INGREDIENT("INSERT INTO dish_ingredient(dish_id, ingredient_id) VALUES((?),(?))");
    String query;

    IngredientSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
