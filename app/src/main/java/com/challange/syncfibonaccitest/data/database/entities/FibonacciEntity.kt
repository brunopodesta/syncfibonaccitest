package com.challange.syncfibonaccitest.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.challange.syncfibonaccitest.domain.model.Fibonacci

@Entity(tableName = "fibonacci_table")
data class FibonacciEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "number") val number : Int,
    @ColumnInfo(name = "saveTime") val saveTime : Long
)

fun Fibonacci.toEntity() = FibonacciEntity(number = number, saveTime = saveTime)