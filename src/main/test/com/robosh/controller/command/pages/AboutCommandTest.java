package com.robosh.controller.command.pages;

import com.robosh.controller.utils.PagesPath;
import org.testng.annotations.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class AboutCommandTest {
    @Test
    public void shouldReturnAboutPage() throws ServletException, IOException {
        AboutCommand aboutCommand = new AboutCommand();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(PagesPath.ABOUT_PAGE)).thenReturn(dispatcher);
        aboutCommand.execute(request, response);
        verify(request, times(1)).getRequestDispatcher(PagesPath.ABOUT_PAGE);
        verify(dispatcher).forward(request, response);
    }
}