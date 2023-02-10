package com.challange.syncfibonaccitest.domain

import com.challange.syncfibonaccitest.data.FibonacciRepository
import javax.inject.Inject

class DeleteLogsUseCase @Inject constructor(private val repository: FibonacciRepository) {

    suspend operator fun invoke() {
        repository.deleteAll()
    }
}