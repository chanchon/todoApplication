package th.ac.kku.cis.lab.todoapplication.repository.database

import android.content.Context
import androidx.room.*
import th.ac.kku.cis.lab.todoapplication.repository.model.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract  class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDAO
    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "Todo.db"
                    )
                        .allowMainThreadQueries()
                        .build()

                }
            }
            return instance
        }

    }
}
