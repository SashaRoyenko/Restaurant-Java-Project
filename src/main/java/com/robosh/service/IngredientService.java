package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.IngredientDao;
import com.robosh.model.entity.Ingredient;

import java.util.List;

/**
 * Class IngredientService
 * realise logic manipulation
 * with db for class Ingredient
 *
 * @author Sasha
 */
public class IngredientService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * This method is used to create new Ingredient in db
     *
     * @param ingredient
     */
    public void createIngredient(Ingredient ingredient) {
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            dao.create(ingredient);
        }

    }

    /**
     * This method is used to get ingredient by it's id from db
     *
     * @param id
     * @return Ingredient
     */
    public Ingredient getIngredientById(long id) {
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.findById(id);
        }
    }

    /**
     * This method is used to get all ingredients from db
     *
     * @return List<Ingredient>
     */
    public List<Ingredient> getAllIngredients() {
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.findAll();
        }
    }

    /**
     * This method is used to get all ingredients from db for certain dish by it's id
     *
     * @param dish_id
     * @return List<Ingredient>
     */
    List<Ingredient> selectDishIngredients(long dish_id) {
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.selectDishIngredients(dish_id);
        }
    }

    /**
     * This method is used to add ingredient into db for certain dish by ingredient id and dish id.
     *
     * @param dish_id
     * @param ingredient_id
     */
    void addDishIngredient(long dish_id, long ingredient_id) {
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            dao.addDishIngredient(dish_id, ingredient_id);
        }
    }
}
