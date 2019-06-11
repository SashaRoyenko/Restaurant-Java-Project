package com.robosh.service;

import org.junit.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserServiceTest {
    private String email = "admin@admin";
    private final String phone = "+380911111111";
    private final String password = "adminAdmin2019";
    private UserService userService;
    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test
    public void shouldReturnTruIfUserWithSuchEmailExist(){
        assertTrue(userService.isEmailTaken(email));
    }

    @Test
    public void shouldReturnTruIfUserWithSuchPhoneExist(){
        assertTrue(userService.isPhoneTaken(phone));
    }

    @Test
    public void shouldReturnTruIfUserWithSuchEmailAndPasswordExist(){
        assertTrue(userService.isUserExist(email, password));
    }
}