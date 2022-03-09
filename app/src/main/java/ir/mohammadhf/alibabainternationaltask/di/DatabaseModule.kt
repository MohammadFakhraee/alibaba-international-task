package ir.mohammadhf.alibabainternationaltask.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.mohammadhf.alibabainternationaltask.AppDatabase
import ir.mohammadhf.alibabainternationaltask.data.source.UserLocalDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my_app_db"
        ).build()

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserLocalDataSource =
        appDatabase.getUserDao()
}