package com.rego.jorge.stringcalculator

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class StringCalculatorFunctionsAdd2 {

    lateinit var sutcalculator: StringCalculatorFunctions

    @Before
    fun setup() {
        sutcalculator = StringCalculatorFunctions()
    }


    @Test
    fun `when input is empty, function add will return 0`() {
        val result = sutcalculator.add2("")
        assert(result == 0)
    }

    @Test
    fun `when input is 1, function add will return 1`() {
        val result = sutcalculator.add2("1")
        assert(result == 1)
    }

    @Test
    fun `when input is 12, function add will return 12`() {
        val result = sutcalculator.add2("12")
        assert(result == 12)
    }

    @Test
    fun `when input is 1,2 , function add will return 3`() {
        val result = sutcalculator.add2("1,2")
        assert(result == 3)
    }

    @Test
    fun `when input is 11,22,33 , function add will return 3`() {
        val result = sutcalculator.add2("11,22,33")
        assert(result == 66)
    }

    @Test(expected = InvalidInputException::class)
    fun `when input is -1,2,3 , function add should throw an exception`() {
        sutcalculator.add2("-1,2,3")
    }

    @Test(expected = InvalidInputException::class)
    fun `when input is -1,-2,3 , function add should throw an exception`() {
        try {
            sutcalculator.add2("-1,-2,3")
        } catch (e: Exception) {
            assert(e is InvalidInputException)
            Assert.assertEquals("Invalid negative numbers [-1, -2]", (e as InvalidInputException).message)
            throw e
        }
    }

    @Test
    fun `when input is 1(br)2, function add will return 3`() {
        val result = sutcalculator.add2("1\n2")
        assert(result == 3)
    }

    @Test
    fun `when input is 1(br)2(br)3 , function add will return 6`() {
        val result = sutcalculator.add2("1\n2\n3")
        assert(result == 6)
    }

    @Test(expected = InvalidDelimiterException::class)
    fun `when input is 1,a , function throw an exception`() {
        sutcalculator.add2("1,a")
    }

    @Test(expected = InvalidDelimiterException::class)
    fun `when input is 1dota , function throw an exception`() {
        sutcalculator.add2("1.a")
    }

    @Test(expected = InvalidDelimiterException::class)
    fun `when input is 1dot , function throw an exception`() {
        sutcalculator.add2("1.")
    }



}