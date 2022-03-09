package th.ac.kku.cis.lab.todoapplication.repository.database

import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverters
    fun fromString(value: String): List<String>{
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value,listType)
    }
}