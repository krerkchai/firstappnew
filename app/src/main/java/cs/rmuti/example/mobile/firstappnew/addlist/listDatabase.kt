package cs.rmuti.example.mobile.firstappnew.addlist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListData::class],version = 1)
abstract class listDatabase:RoomDatabase() {


    companion object{
        @Volatile
        private var model : listDatabase?=null
        fun getDatabase(context: Context): listDatabase? {
            synchronized(this) {
                var _model = model

                if (_model == null) {
                    model = Room.databaseBuilder(
                        context.applicationContext,
                        listDatabase::class.java,
                        "contacts_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    model = _model
                }
                return _model
            }


            }
        }

    abstract val listDAO:ListDAO
}