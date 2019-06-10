package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.DishDao;
import com.robosh.model.dao.IngredientDao;
import com.robosh.model.entity.Dish;

import java.util.List;

public class DishService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void createDish(Dish Dish) {
        try (DishDao dao = daoFactory.createDishDao()) {
            dao.create(Dish);
        }

    }

    public Dish getDishById(long id) {
        Dish dish;
        try (DishDao dao = daoFactory.createDishDao();
             IngredientDao ingredientDao = daoFactory.createIngredientDao()) {
            dish = dao.findById(id);
            dish.setIngredientList(dao.selectDishIngredients(dish));
        }
        return dish;
    }

    public List<Dish> getAllDishes() {
        List<Dish> dishes;
        try (DishDao dao = daoFactory.createDishDao();
             IngredientDao ingredientDao = daoFactory.createIngredientDao()) {
            dishes = dao.findAll();
            dishes.forEach(
                    d -> {
                        d.setIngredientList(dao.selectDishIngredients(d));
                    }
            );
        }
        return dishes;
    }

}
