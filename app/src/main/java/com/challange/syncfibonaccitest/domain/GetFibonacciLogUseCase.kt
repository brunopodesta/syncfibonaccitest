package com.challange.syncfibonaccitest.domain

import com.challange.syncfibonaccitest.data.FibonacciRepository
import com.challange.syncfibonaccitest.domain.model.Fibonacci
import javax.inject.Inject

class GetFibonacciLogUseCase @Inject constructor(private val repository: FibonacciRepository) {

    suspend operator fun invoke() : List<Fibonacci> {
        val registers = repository.getAllNumber()
        return registers.ifEmpty {
            emptyList()
        }
    }

}