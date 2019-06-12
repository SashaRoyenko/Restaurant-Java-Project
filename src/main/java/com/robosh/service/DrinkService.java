package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.DrinkDao;
import com.robosh.model.entity.Drink;

import java.util.List;

/**
 * Class DrinkService
 * realise logic manipulation
 * with db for class Drink
 *
 * @author Sasha
 */
public class DrinkService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    /**
     * Used to create new drink in db
     *
     * @param drink
     */
    public void createDrink(Drink drink) {
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            dao.create(drink);
        }

    }

    /**
     * Used to get drink by it's id in db
     *
     * @param id
     * @return Drink
     */
    public Drink getDrinkById(long id) {
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            return dao.findById(id);
        }
    }

    /**
     * Used to det all drinks from db
     *
     * @return List<Drink>
     */
    public List<Drink> getAllDrinks() {
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            return dao.findAll();
        }
    }
}
