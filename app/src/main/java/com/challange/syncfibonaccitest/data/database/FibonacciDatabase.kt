package com.challange.syncfibonaccitest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.challange.syncfibonaccitest.data.database.dao.FibonacciDao
import com.challange.syncfibonaccitest.data.database.entities.FibonacciEntity

@Database(entities = [FibonacciEntity::class], version = 1)
abstract class FibonacciDatabase : RoomDatabase() {

    abstract fun getFibonacciDao() : FibonacciDao

}