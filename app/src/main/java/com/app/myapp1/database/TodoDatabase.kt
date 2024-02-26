package com.app.myapp1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.myapp1.dao.TodoDao

import com.app.myapp1.dto.Todo;

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class TodoDatabase: RoomDatabase() {
abstract fun todoDao(): TodoDao
        }