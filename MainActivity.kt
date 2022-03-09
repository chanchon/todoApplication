package com.example.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.repository.Todo
import com.example.todoapplication.repository.TodoRepository

class MainActivity : AppCompatActivity() {
    lateinit var adapter: TodoAdapter
    val repo:TodoRepository by lazy{
        TodoRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TodoAdapter()
        var recyclerView:RecyclerView = findViewById(R.id.recycleView_todo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getDataFromDatabase()
        adapter.setOnItemClick(object: ListClickListener<Todo>{
            override fun onClink(data: Todo, position: Int) {
                val intent = Intent(this@MainActivity,
                    NewTodoActivity::class.java)
                intent.putExtra("TODODATA", data)
                startActivity(intent)
            }
        })

        var btnNew:Button = findViewById(R.id.btnNew)
        btnNew.setOnClickListener {
            var intent = Intent(this, NewTodoActivity::class.java)
            startActivity(intent)
        }
    }
    // when finish insert new todo data
    override fun onResume() {
        super.onResume()
        getDataFromDatabase()
    }
    fun getDataFromDatabase(){
        val todo_from_db = repo.getAllTodo()
        adapter.setTodo(todo_from_db)
    }
}