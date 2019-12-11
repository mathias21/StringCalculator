package com.rego.jorge.stringcalculator

class StringCalculatorFunctions {


    fun add(textToAdd: String): Int {
        if (textToAdd.isEmpty()) return 0
        var accumulatedValue = 0
        return try {
            val numbersToAdd = textToAdd.split(",")
            numbersToAdd.forEach {
                accumulatedValue += it.toInt()
            }
            accumulatedValue
        } catch (e: Exception) {
            throw InvalidInputException()
        }
    }

}

class InvalidInputException : Exception()