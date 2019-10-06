package id.ndcreative.temansaya

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Created by Umar Fadil on 06,Oct,2019
 * ND Creative Solution
 * id.ndcreativesolution@gmail.com
 */

@Database(entities = [Teman::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun temanDao(): TemanDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(contex: Context) : AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(contex.applicationContext,
                        AppDatabase::class.java, "TemanAppDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}