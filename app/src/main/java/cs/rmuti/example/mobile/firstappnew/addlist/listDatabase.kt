package cs.rmuti.example.mobile.firstappnew.addlist

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ListData::class],version = 1)
abstract class listDatabase:RoomDatabase() {


    companion object{
        @Volatile
        private var model : listDatabase?=null
        fun getDatabase(context: Context):listDatabase{
            return model?: synchronized(this)

            }
        }
    
    abstract val listDAO:listDAO
}