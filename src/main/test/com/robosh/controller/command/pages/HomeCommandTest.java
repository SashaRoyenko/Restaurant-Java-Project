package com.robosh.controller.command.pages;

import com.robosh.controller.utils.PagesPath;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class HomeCommandTest {

    @Test
    public void shouldReturnHomePage() throws ServletException, IOException {
        HomeCommand homeCommand = new HomeCommand();
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(PagesPath.HOME_PAGE)).thenReturn(dispatcher);
        homeCommand.execute(request, response);
        verify(request, times(1)).getRequestDispatcher(PagesPath.HOME_PAGE);
        verify(dispatcher).forward(request, response);
    }
}