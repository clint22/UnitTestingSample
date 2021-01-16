package com.clintpauldev.unittestingsample

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {

        val result = RegistrationUtil.validateRegistrationInput(
                userName = "",
                password = "123",
                confirmPassword = "123"
        )
        assertThat(result).isFalse()

    }


    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
                "clint",
                "123",
                "123"
        )
        assertThat(result).isTrue()
    }


    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
                "Peter",
                "123",
                "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
                "Peter",
                "",
                ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password repeated incorrectly returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
                "Peter",
                "123",
                "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
                "Peter",
                "1abcd",
                "1abcd"
        )
        assertThat(result).isFalse()
    }


}