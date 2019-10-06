package id.ndcreative.temansaya

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Umar Fadil on 05,Oct,2019
 * ND Creative Solution
 * id.ndcreativesolution@gmail.com
 */

@Entity
data class Teman (
    @PrimaryKey(autoGenerate = true)
    val temanId : Int? = null,
    val nama : String,
    val jenisKelamin : String,
    val email : String,
    val telp : String,
    val alamat : String,

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null
)