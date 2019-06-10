package com.robosh.controller.command.pages;

import com.robosh.controller.command.Command;
import com.robosh.controller.utils.PagesPath;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.service.DishService;
import com.robosh.service.DrinkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MenuCommand implements Command {
    private DishService dishService;
    private DrinkService drinkService;

    public MenuCommand(DishService dishService, DrinkService drinkService) {
        this.dishService = dishService;
        this.drinkService = drinkService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Dish> dishList = dishService.getAllDishes();
        List<Drink> drinkList = drinkService.getAllDrinks();
        request.setAttribute("drinkList", drinkList);
        request.setAttribute("dishList", dishList);
        request.getRequestDispatcher(PagesPath.MENU_PAGE).forward(request, response);
    }
}
