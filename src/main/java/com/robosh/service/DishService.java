package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.DishDao;
import com.robosh.model.dao.IngredientDao;
import com.robosh.model.entity.Dish;

import java.util.List;

/**
 * Class DishService
 * realise logic manipulation
 * with db for class Dish
 *
 * @author Sasha
 */
public class DishService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * Create new dish in db
     *
     * @param Dish
     */
    public void createDish(Dish Dish) {
        try (DishDao dao = daoFactory.createDishDao()) {
            dao.create(Dish);
        }

    }

    /**
     * Used to get dish by certain id
     *
     * @param id
     * @return Dish
     */
    public Dish getDishById(long id) {
        Dish dish;
        try (DishDao dao = daoFactory.createDishDao();
             IngredientDao ingredientDao = daoFactory.createIngredientDao()) {
            dish = dao.findById(id);
            dish.setIngredientList(dao.selectDishIngredients(dish));
        }
        return dish;
    }

    /**
     * Used to get all dishes with it's ingredients from db
     *
     * @return List<Dish>
     */
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
