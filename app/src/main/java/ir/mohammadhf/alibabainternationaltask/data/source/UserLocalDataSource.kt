package ir.mohammadhf.alibabainternationaltask.data.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.mohammadhf.alibabainternationaltask.data.model.User

@Dao
interface UserLocalDataSource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(users: List<User>)

    @Query("SELECT * FROM users ORDER BY id")
    suspend fun getLocalUsers(): List<User>
}