package com.example.samples.kotlinrx2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.core.Client
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.rx2.rxSingle

class MainActivity : AppCompatActivity() {

    private val githubClient = Client()

    lateinit var observable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observable = rxSingle { githubClient.getReposAsync("benjaminledet") }.subscribe({ result ->
            Log.d("MainActivity", result.toString())
        }, { exception ->
            Log.e("MainActivity", "getReposAsync", exception)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        observable.dispose()
    }
}
