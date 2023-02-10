package com.challange.syncfibonaccitest.data

import com.challange.syncfibonaccitest.data.database.dao.FibonacciDao
import com.challange.syncfibonaccitest.data.database.entities.FibonacciEntity
import com.challange.syncfibonaccitest.domain.model.Fibonacci
import com.challange.syncfibonaccitest.domain.model.toDomain
import javax.inject.Inject

class FibonacciRepository @Inject constructor(
    private val fibonacciDao : FibonacciDao,
    private val fibonacciProvider: FibonacciProvider
) {

    fun getNumber() : Int {
        return fibonacciProvider.getFibonacciNumber()
    }

    suspend fun insertNumber(fibonacciEntity: FibonacciEntity) {
        fibonacciDao.insertNumber(fibonacciEntity)
    }

    suspend fun getAllNumber() : List<Fibonacci> {
        val response = fibonacciDao.getAllNumbers()
        return response.map { it.toDomain() }
    }

    suspend fun deleteAll() {
        fibonacciDao.deleteAll()
    }


}