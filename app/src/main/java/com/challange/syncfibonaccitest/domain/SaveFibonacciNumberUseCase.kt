package com.challange.syncfibonaccitest.domain

import com.challange.syncfibonaccitest.data.FibonacciRepository
import com.challange.syncfibonaccitest.data.database.entities.toEntity
import com.challange.syncfibonaccitest.domain.model.Fibonacci
import javax.inject.Inject

class SaveFibonacciNumberUseCase @Inject constructor(private val repository: FibonacciRepository) {

    suspend fun saveFibonnaciNumber(fibonacci: Fibonacci) {
        repository.insertNumber(fibonacci.toEntity())
    }
}