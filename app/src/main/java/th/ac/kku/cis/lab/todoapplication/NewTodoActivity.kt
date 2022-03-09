package th.ac.kku.cis.lab.todoapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import th.ac.kku.cis.lab.todoapplication.repository.TodoRepository
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo

class NewTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)



        //get data from iui
        var etName: EditText = findViewById(R.id.editText_name)
        var etDetail: EditText = findViewById(R.id.editText_detail)


        var repository = TodoRepository(this)

        var btnDelete:Button = findViewById (R.id.btnDelete)
        var btnSave:Button = findViewById(R.id.btnSave)
        var todoData:Todo? = intent.getParcelableExtra("TODODATA")
        btnSave.setOnClickListener{
            if(etName.text.isNotEmpty()){
                todoData?.let{
                    var todoUpdateData = Todo (it.id,
                        etName.text.toString(),
                        etDetail.text.toString(), false
                    )
                    repository.updateTodo (todoUpdateData)
                }?:kotlin.run{
                    var newTodo = Todo(null,
                    etName.text.toString(),
                    etDetail.text.toString(), false
                    )
                    repository.insertTodo(newTodo)
                }
                    var todoDeleteData = Todo ( null,
                        etName.text.toString(),
                        etDetail.text.toString(),false
                    )
                     repository.deleteTodo (todoDeleteData)

                finish()
            }else{
                Toast.makeText( this, "todo not emty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}