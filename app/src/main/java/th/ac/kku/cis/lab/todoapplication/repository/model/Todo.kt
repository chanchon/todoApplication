package th.ac.kku.cis.lab.todoapplication.repository.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Todo")
data class Todo (@PrimaryKey(autoGenerate = true) var id:Int? = null,

                 var todo_name:String?,
                 var todo_detail:String?,
                 var todo_done:Boolean) : Parcelable{

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeString(todo_name)
        dest.writeString(todo_detail)
        dest.writeBoolean(todo_done)
    }
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString() as String,
        parcel.readString(),
        parcel.readBoolean(),

    )
    companion object CREATOR : Parcelable.Creator<Todo>{
        override fun createFromParcel(source: Parcel): Todo {
            return Todo(source)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return  arrayOfNulls(size)
        }

    }
}
