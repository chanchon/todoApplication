package th.ac.kku.cis.lab.todoapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import th.ac.kku.cis.lab.todoapplication.repository.TodoRepository
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo

class MainActivity : AppCompatActivity() {
    lateinit var adapter: TodoAdapter
    val repo: TodoRepository by lazy{
        TodoRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TodoAdapter()
        var recyclerView: RecyclerView = findViewById (R.id.recycleView_todo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        getDataFromDatabase ()
        adapter.setOnItemClick(object: ListClickListener<Todo>{
            override fun onClink (data: Todo, position: Int) {
                val intent = Intent(this@MainActivity,
                NewTodoActivity::class.java)
                intent.putExtra("TODODATA", data)
                startActivity(intent)
            }
        })
        val todo_from_db = repo.getAllTodo()
        adapter.setTodo (todo_from_db)

        var btnNew:Button = findViewById(R.id.btnNew)
        btnNew.setOnClickListener{
            var intent = Intent(this,NewTodoActivity::class.java)
            startActivity(intent)

        }
    }
    override fun onResume(){
        super.onResume()
    }
    fun getDataFromDatabase(){
        val todo_from_db = repo.getAllTodo()
        adapter.setTodo(todo_from_db)
    }
}