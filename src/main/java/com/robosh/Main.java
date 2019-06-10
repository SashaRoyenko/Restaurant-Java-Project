package com.robosh;

import com.robosh.model.entity.Drink;
import com.robosh.model.entity.OrderProducts;
import com.robosh.service.DrinkService;
import com.robosh.service.OrderProductsService;

public class Main {
    public static void main(String[] args) {
        DrinkService drinkService = new DrinkService();
        Drink drink = drinkService.getDrinkById(2);
        OrderProductsService orderProductsService = new OrderProductsService();
        OrderProducts orderProducts = orderProductsService.getOrderProductsById(1);
        orderProductsService.deleteDrink(drink, orderProducts);
    }
}
