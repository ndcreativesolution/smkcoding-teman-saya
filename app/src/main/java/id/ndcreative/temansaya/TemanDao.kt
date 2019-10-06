package id.ndcreative.temansaya

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * Created by Umar Fadil on 06,Oct,2019
 * ND Creative Solution
 * id.ndcreativesolution@gmail.com
 */

@Dao
interface TemanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahTeman(friend: Teman)

    @Query("SELECT * from Teman")
    fun ambilSemuaTeman(): LiveData<List<Teman>>
}