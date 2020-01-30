package vk.expencive.kotlinsingletonexample.api

import retrofit2.http.GET
import retrofit2.http.Path
import vk.expencive.kotlinsingletonexample.models.User

interface ApiService {

    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): User

}