package com.example.samples.kotlincallbacks

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.core.Client
import com.example.core.response.Repo
import com.example.kotlincallbacks.ResponseListener
import com.example.kotlincallbacks.call

class MainActivity : AppCompatActivity() {

    private val githubClient = Client()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = object: ResponseListener<List<Repo>> {
            override fun onSuccess(result: List<Repo>) {
                Log.d("MainActivity", result.toString())
            }

            override fun onError(exception: Exception) {
                Log.e("MainActivity", "getReposAsync", exception)
            }
        }
        githubClient.call(listener) {
            getReposAsync("benjaminledet")
        }
    }
}

