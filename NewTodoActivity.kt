package com.example.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.todoapplication.repository.Todo
import com.example.todoapplication.repository.TodoRepository

class NewTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        var etTodoName:EditText = findViewById(R.id.editText_name)
        var etTodoDetail:EditText = findViewById(R.id.editText_detail)

        var repository = TodoRepository(this)

        var todoData:Todo? = intent.getParcelableExtra("TODODATA")
        var btnSave:Button = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {
            if(etTodoName.text.isNotEmpty()){
                todoData?.let {
                    var todoUpdateData = Todo(it.id,
                        etTodoName.text.toString(),
                        etTodoDetail.text.toString(),false
                    )
                    repository.updateTodo(todoUpdateData)
                } ?: kotlin.run { //insert
                    var newTodo = Todo(null,
                        etTodoName.text.toString(),
                        etTodoDetail.text.toString(),false
                    )
                    repository.insertTodo(newTodo)
                }
                finish()
            }else{
                Toast.makeText(this, "Todo name can't be empty",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}