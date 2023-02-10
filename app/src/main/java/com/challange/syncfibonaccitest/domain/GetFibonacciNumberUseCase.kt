package com.challange.syncfibonaccitest.domain

import com.challange.syncfibonaccitest.data.FibonacciRepository
import javax.inject.Inject

class GetFibonacciNumberUseCase @Inject constructor(private val repository: FibonacciRepository) {

    operator fun invoke() : Int {
        return repository.getNumber()
    }

}