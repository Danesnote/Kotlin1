package com.app.myapp1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.app.myapp1.database.TodoDatabase
import com.app.myapp1.dto.Todo
import java.lang.IllegalStateException

private const val DATABASE_NAME = "todo-database.db"
class TodoRepository private constructor(context: Context){

    //데이터베이스 빌드
    private val database: TodoDatabase = Room.databaseBuilder(
            context.applicationContext,
            TodoDatabase::class.java,
            DATABASE_NAME
    ).build()

    private val todoDao = database.todoDao()

    fun list(): LiveData<MutableList<Todo>> = todoDao.list()

    fun getTodo(id: Long): Todo = todoDao.selectOne(id)

    fun insert(dto: Todo) = todoDao.insert(dto)

    suspend fun update(dto: Todo) = todoDao.update(dto)

    fun delete(dto: Todo) = todoDao.delete(dto)

    companion object {
        private var INSTANCE: TodoRepository?=null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TodoRepository(context)
            }
        }

        fun get(): TodoRepository {
            return INSTANCE ?:
            throw IllegalStateException("TodoRepository must be initialized")
        }
    }
}
