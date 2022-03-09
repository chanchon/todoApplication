package th.ac.kku.cis.lab.todoapplication.repository

import android.content.Context
import android.util.Log
import th.ac.kku.cis.lab.todoapplication.repository.database.AppDatabase
import th.ac.kku.cis.lab.todoapplication.repository.database.TodoDAO
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo

class TodoRepository(context: Context) {
    var db: TodoDAO = AppDatabase.getInstance(context)?.todoDao()!!
    fun getAllTodo(): List<Todo> {
        return db.getAllTodo()
    }

    fun insertTodo(todo: Todo) {
        Thread(Runnable {
            db.insertTodo(todo)
        }).start()
    }

    fun updateTodo(todo: Todo) {
        db.updateTodo(todo)
    }

    fun deleteTodo(todo: Todo) {
        db.deleteTodo(todo)
    }

}