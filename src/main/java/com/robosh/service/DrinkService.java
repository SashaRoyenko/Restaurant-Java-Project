package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.DrinkDao;
import com.robosh.model.entity.Drink;

import java.util.List;

public class DrinkService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void createDrink(Drink drink){
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            dao.create(drink);
        }

    }

    public Drink getDrinkById(long id){
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            return dao.findById(id);
        }
    }

    public List<Drink> getAllDrinks(){
        try (DrinkDao dao = daoFactory.createDrinkDao()) {
            return dao.findAll();
        }
    }
}
