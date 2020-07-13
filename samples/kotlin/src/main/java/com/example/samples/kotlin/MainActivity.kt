package com.example.samples.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.core.Client
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val githubClient = Client()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            try {
                val result = githubClient.getReposAsync("benjaminledet")
                Log.d("MainActivity", result.toString())
            } catch (exception: Exception) {
                Log.e("MainActivity", "getReposAsync", exception)
            }
        }
    }
}
