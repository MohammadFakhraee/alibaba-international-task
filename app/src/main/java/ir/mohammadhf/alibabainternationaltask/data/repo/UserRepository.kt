package ir.mohammadhf.alibabainternationaltask.data.repo

import ir.mohammadhf.alibabainternationaltask.InternetChecker
import ir.mohammadhf.alibabainternationaltask.data.model.User
import ir.mohammadhf.alibabainternationaltask.data.source.UserApiDataSource
import ir.mohammadhf.alibabainternationaltask.data.source.UserLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userApiDataSource: UserApiDataSource,
    private val internetChecker: InternetChecker
) {

    suspend fun getUsers(page: Int): List<User> {
        return withContext(Dispatchers.IO) {
            if (internetChecker.isNetworkAvailable()) {
                val users = userApiDataSource.getUsers(page)
                userLocalDataSource.saveAll(users.data)
                users.data
            } else
                userLocalDataSource.getLocalUsers()
        }
    }
}