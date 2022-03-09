package ir.mohammadhf.alibabainternationaltask

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.mohammadhf.alibabainternationaltask.data.model.User
import ir.mohammadhf.alibabainternationaltask.data.source.UserLocalDataSource

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserLocalDataSource
}