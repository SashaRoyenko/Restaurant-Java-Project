package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.IngredientDao;
import com.robosh.model.entity.Ingredient;

import java.util.List;

public class IngredientService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void createIngredient(Ingredient ingredient){
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            dao.create(ingredient);
        }

    }

    public Ingredient getIngredientById(long id){
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.findById(id);
        }
    }

    public List<Ingredient> getAllIngredients(){
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.findAll();
        }
    }

    List<Ingredient> selectDishIngredients(long dish_id){
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            return dao.selectDishIngredients(dish_id);
        }
    }

    void addDishIngredient(long dish_id, long ingredient_id){
        try (IngredientDao dao = daoFactory.createIngredientDao()) {
            dao.addDishIngredient(dish_id, ingredient_id);
        }
    }
}
