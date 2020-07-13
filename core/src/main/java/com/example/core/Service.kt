package com.example.core

import com.example.core.response.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("users/{user}/repos")
    suspend fun listReposAsync(@Path("user") user: String?): List<Repo>

}