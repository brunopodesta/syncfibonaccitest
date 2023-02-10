package com.challange.syncfibonaccitest.domain.model

import com.challange.syncfibonaccitest.data.database.entities.FibonacciEntity

data class Fibonacci(val number : Int,
                     val saveTime : Long)

fun FibonacciEntity.toDomain() = Fibonacci(number = number, saveTime = saveTime)