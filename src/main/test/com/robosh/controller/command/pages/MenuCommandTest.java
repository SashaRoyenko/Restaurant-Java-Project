package com.robosh.controller.command.pages;

import com.robosh.controller.utils.PagesPath;
import com.robosh.model.entity.Dish;
import com.robosh.model.entity.Drink;
import com.robosh.service.DishService;
import com.robosh.service.DrinkService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuCommandTest {
    @InjectMocks
    private MenuCommand menuCommand;
    @Mock
    private DishService dishService;
    @Mock
    private DrinkService drinkService;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpServletRequest request;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private List<Dish> dishList;
    @Mock
    private List<Drink> drinkList;

    @Before
    public void setUp() {
        dishService = new DishService();
        drinkService = new DrinkService();
        menuCommand = new MenuCommand(dishService, drinkService);
        dishList = dishService.getAllDishes();
        drinkList = drinkService.getAllDrinks();

        when(request.getRequestDispatcher(PagesPath.MENU_PAGE)).thenReturn(requestDispatcher);
    }

    @Test
    public void shouldReturnMenuCommandWithSetParameters() throws IOException, ServletException {
        menuCommand.execute(request, response);
        verify(request, times(1))
                .setAttribute("drinkList", drinkList);
        verify(request, times(1))
                .setAttribute("dishList", dishList);
        verify(requestDispatcher).forward(request, response);
    }
}