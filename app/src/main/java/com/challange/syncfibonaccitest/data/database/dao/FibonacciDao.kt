package com.challange.syncfibonaccitest.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.challange.syncfibonaccitest.data.database.entities.FibonacciEntity

@Dao
interface FibonacciDao {

    @Query("SELECT * FROM fibonacci_table ORDER BY saveTime DESC")
    suspend fun getAllNumbers() : List<FibonacciEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumber(fibonacciEntity: FibonacciEntity)

    @Query("DELETE FROM fibonacci_table")
    suspend fun deleteAll()

}