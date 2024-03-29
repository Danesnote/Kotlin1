package com.app.myapp1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import com.app.myapp1.dto.Todo

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto:Todo)

    @Query("select * from todoTable")
    fun list(): LiveData<MutableList<Todo>>
    //LiveData는 추가,수정,삭제에 의해 변화하는 값에 대해 즉시 반영


    @Query("select * from todoTable where id = (:id)")
    fun selectOne(id: Long): Todo

    @Update
    suspend fun update(dto: Todo)

    @Delete
    fun delete(dto: Todo)
}
