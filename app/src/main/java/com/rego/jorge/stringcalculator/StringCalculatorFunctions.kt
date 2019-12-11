package com.rego.jorge.stringcalculator

class StringCalculatorFunctions {

    fun add(textToAdd: String): Int {
        if (textToAdd.isEmpty()) return 0
        var accumulatedValue = 0
        return try {
            val numbersToAdd = textToAdd.split(",", "\n")
            numbersToAdd.forEach {
                val numberValue = it.toInt()
                if (numberValue < 0) {
                    throw InvalidInputException()
                }
                accumulatedValue += numberValue
            }
            accumulatedValue
        } catch (e: Exception) {
            throw InvalidInputException()
        }
    }

    fun add2(textToAdd: String): Int {
        return if (textToAdd.isEmpty()) {
            0
        } else {
            val numbers = textToAdd.split(",", "\n")
                .map {
                    try {
                        it.toInt()
                    } catch (e: Exception) {
                        throw InvalidDelimiterException()
                    }
                }
            val negativeNumbers = numbers.filter { it<0 }
            if(negativeNumbers.isNotEmpty()) throw InvalidInputException("Invalid negative numbers $negativeNumbers")
            numbers.sum()
        }
    }

}

class InvalidInputException(message: String = "") : Exception(message)

class InvalidDelimiterException(message: String = "") : Exception(message)