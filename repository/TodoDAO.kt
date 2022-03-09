package com.example.todoapplication.repository

import androidx.room.*

@Dao
interface TodoDAO {
    @Insert
    fun insertTodo(todo: Todo)
    @Update
    fun updateTodo(todo: Todo)
    @Delete
    fun deleteTodo(todo: Todo)
    @Query("SELECT * FROM todo")
    fun getAllTodo(): List<Todo>
}