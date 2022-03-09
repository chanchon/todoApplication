package th.ac.kku.cis.lab.todoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){
    var todoList = mutableListOf<Todo>()
    fun setTodo (todos: List<Todo>){
        todoList = todos.toMutableList()
        notifyDataSetChanged ()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent,  false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todoList[position]
        holder.todo_name.text = todo.todo_name
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
    var clickListener:ListClickListener<Todo>? = null
    fun setOnItemClick(listener: ListClickListener<Todo>){
        this.clickListener = listener
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var todo_name: TextView = view.findViewById(R.id.tvItem_name)
    }
}
interface ListClickListener<T> {
    fun onClink(data: T, position: Int)

}


