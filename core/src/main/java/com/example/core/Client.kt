package com.example.core

import com.example.core.response.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class is the GithubClient
 */
class Client(private val logHttpBody: Boolean = false) {

    private val okHttpClient = OkHttpClient.Builder()
        .apply {
            if (logHttpBody) {
                addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            }
        }
        .build()


    private val service = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Service::class.java)

    /**
     * Get the repos of a user
     */
    suspend fun getReposAsync(userName: String): List<Repo> = withContext(Dispatchers.IO) {
        //throw Exception("exception")
        service.listReposAsync(userName)
    }

}