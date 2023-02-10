package com.challange.syncfibonaccitest.data

import javax.inject.Inject

class FibonacciProvider @Inject constructor(){

    private val numbers = getNumbers()

    fun getFibonacciNumber() : Int {
        val position = (0..29).random()
        return numbers[position]
    }

    private fun getNumbers() : List<Int> {
        return generateFibonacci().take(30).toList()
    }

    private fun generateFibonacci() :Sequence<Int> {
        return generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }.map { it.first }
    }

}