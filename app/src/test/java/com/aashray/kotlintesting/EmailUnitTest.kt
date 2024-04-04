package com.aashray.kotlintesting

import org.junit.Assert
import org.junit.Test

class EmailUnitTest {
    @Test
    fun testIsValidEmail_CorrectFormat() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun testIsValidEmail_CorrectSubdomainFormat() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun testIsValidEmail_IncorrectDomain() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun testIsValidEmail_DoubleDots() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun testIsValidEmail_NoUsername() {
        Assert.assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun testIsValidEmail_NoDomain() {
        Assert.assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun testIsValidEmail_EmptyString() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun testIsValidEmail_Null() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }
}