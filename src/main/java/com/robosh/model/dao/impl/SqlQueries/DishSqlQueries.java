package com.robosh.model.dao.impl.SqlQueries;

public enum DishSqlQueries {
    CREATE_DISH("INSERT INTO dish(name, price, weight) VALUES((?),(?),(?));"),
    FIND_DISH_BY_ID(
            "SELECT dish_id, name, price, weight" +
            " FROM dish WHERE `dish_id`= (?)"),
    FIND_ALL_DISHES(
            "SELECT dish_id, name, price, weight" +
            " FROM dish"),
    DELETE_DISH("DELETE FROM  dish WHERE (dish_id = (?))"),
    ADD_DISH_INGREDIENT("INSERT INTO" +
                                " dish_ingredients(dish_dish_id, dish_ingredients_id)" +
                                "VALUES((?), (?))"),
    FIND_DISH_INGREDIENTS("SELECT ingredient_id, ingredient_name" +
            " FROM dish, dish_ingredients, ingredient WHERE" +
            " `dish_id` = `dish_dish_id`" +
            " AND `ingredient_id` = `ingredient_ingredient_id`" +
            "AND dish_id = (?)");
    String query;
    DishSqlQueries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
