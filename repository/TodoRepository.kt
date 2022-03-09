package com.example.todoapplication.repository

import android.content.Context

class TodoRepository(context: Context) {
    var db:TodoDAO = AppDatabase.getInstance(context)?.todoDao()!!
    fun getAllTodo():List<Todo>{
        return db.getAllTodo()
    }
    fun insertTodo(todo:Todo){
        Thread(Runnable {
            db.insertTodo(todo)
        }).start()
    }
    fun updateTodo(todo: Todo){
        db.updateTodo(todo)
    }
    fun delete(todo: Todo){
        db.deleteTodo(todo)
    }
}