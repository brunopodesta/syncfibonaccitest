package com.challange.syncfibonaccitest.di

import android.content.Context
import androidx.room.Room
import com.challange.syncfibonaccitest.data.database.FibonacciDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val FIBONACCI_DATABASE = "fibonacci_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FibonacciDatabase::class.java, FIBONACCI_DATABASE).build()

    @Singleton
    @Provides
    fun provideDao(db : FibonacciDatabase) = db.getFibonacciDao()
}