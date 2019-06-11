package com.robosh.controller.utils;

import static junit.framework.TestCase.*;

import org.junit.*;

public class InputDataUtilTest {
    @Test
    public void shouldReturnTrueIfEmailIsCorrect() {
        final String correctEmail = "email@email.com";
        assertTrue(InputDataUtil.isCorrectEmail(correctEmail));
    }

    @Test
    public void shouldReturnTrueIfPhoneIsCorrect() {
        final String correctPhone1 = "0982827486";
        final String correctPhone2 = "+380982827486";
        assertTrue(InputDataUtil.isCorrectPhone(correctPhone1));
        assertTrue(InputDataUtil.isCorrectPhone(correctPhone2));
    }

    @Test
    public void shouldReturnTrueIfNameIsCorrect() {
        final String correctName1 = "Sasha";
        final String correctName2 = "Саша";
        assertTrue(InputDataUtil.isCorrectName(correctName1));
        assertTrue(InputDataUtil.isCorrectName(correctName2));
    }

    @Test
    public void shouldReturnTrueIfPasswordIsCorrect() {
        final String correctPassword = "qwertyQwerty2019";
        assertTrue(InputDataUtil.isCorrectPassword(correctPassword));
    }

    @Test
    public void shouldReturnFalseIfEmailIsUnCorrect() {
        final String unCorrectEmail = "email@emailcom";
        assertFalse(InputDataUtil.isCorrectEmail(unCorrectEmail));
    }

    @Test
    public void shouldReturnFalseIfPhoneIsUnCorrect() {
        final String unCorrectPhone1 = "0982827486123321";
        final String unCorrectPhone2 = "+3(8098)282-7486";
        assertFalse(InputDataUtil.isCorrectPhone(unCorrectPhone1));
        assertFalse(InputDataUtil.isCorrectPhone(unCorrectPhone2));
    }

    @Test
    public void shouldReturnFalseIfNameIsUnCorrect() {
        final String unCorrectName1 = "1Sasha";
        final String unCorrectName2 = "Са";
        assertFalse(InputDataUtil.isCorrectName(unCorrectName1));
        assertFalse(InputDataUtil.isCorrectName(unCorrectName2));
    }

    @Test
    public void shouldReturnFalseIfPasswordIsUnCorrect() {
        final String unCorrectPassword1 = "qwerty";
        final String unCorrectPassword2 = "QWERTY2019123";
        final String unCorrectPassword3 = "123124212334";
        assertFalse(InputDataUtil.isCorrectPassword(unCorrectPassword1));
        assertFalse(InputDataUtil.isCorrectPassword(unCorrectPassword2));
        assertFalse(InputDataUtil.isCorrectPassword(unCorrectPassword3));
    }

    @Test
    public void shouldRemoveSpaces() {
        final String stringWithSpaces = "   f i   r  s t   ";
        final String withoutSpaces = "first";
        assertEquals(withoutSpaces, InputDataUtil.removeSpaces(stringWithSpaces));
    }
}