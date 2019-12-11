package com.rego.jorge.stringcalculator

import org.junit.Before
import org.junit.Test

class StringCalculatorFunctionsAdd {

    lateinit var sutcalculator: StringCalculatorFunctions

    @Before
    fun setup() {
        sutcalculator = StringCalculatorFunctions()
    }


    @Test
    fun `when input is empty, function add will return 0`() {
        val result = sutcalculator.add("")
        assert(result == 0)
    }

    @Test
    fun `when input is 1, function add will return 1`() {
        val result = sutcalculator.add("1")
        assert(result == 1)
    }

    @Test
    fun `when input is 12, function add will return 12`() {
        val result = sutcalculator.add("12")
        assert(result == 12)
    }

    @Test
    fun `when input is 1,2 , function add will return 3`() {
        val result = sutcalculator.add("1,2")
        assert(result == 3)
    }

    @Test(expected = InvalidInputException::class)
    fun `when input is 1,a , function throw an exception`() {
        sutcalculator.add("1,a")
    }

    @Test(expected = InvalidInputException::class)
    fun `when input is 1dota , function throw an exception`() {
        sutcalculator.add("1.a")
    }

    @Test(expected = InvalidInputException::class)
    fun `when input is 1dot , function throw an exception`() {
        sutcalculator.add("1.")
    }
}