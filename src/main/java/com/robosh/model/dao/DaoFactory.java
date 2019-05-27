package com.robosh.model.dao;

import com.robosh.model.dao.impl.ImplDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();

    public abstract DishDao createDishDao();

    public abstract DrinkDao createDrinkDao();

    public abstract IngredientDao createIngredientDao();

    public abstract OrderDao createOrderDao();

    public abstract OrderProductsDao createOrderProductsDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new ImplDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
