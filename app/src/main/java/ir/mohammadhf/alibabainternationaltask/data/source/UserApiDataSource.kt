package ir.mohammadhf.alibabainternationaltask.data.source

import ir.mohammadhf.alibabainternationaltask.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiDataSource {

    @GET("users/")
    suspend fun getUsers(@Query("page") page: Int = 1): Response
}