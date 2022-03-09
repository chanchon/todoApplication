package th.ac.kku.cis.lab.todoapplication.repository.database

import androidx.room.*
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo


@Dao
interface TodoDAO {
    @Insert
    fun insertTodo(data: Todo)
    @Update
    fun updateTodo(data: Todo)
    @Delete
    fun deleteTodo(data: Todo)
    @Query("SELECT * FROM todo")
    fun getAllTodo() : List<Todo>
}