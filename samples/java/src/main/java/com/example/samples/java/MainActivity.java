package com.example.samples.java;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.java.Continuation;
import com.example.core.Client;
import com.example.core.response.Repo;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Client client = new Client();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client.getReposAsync("benjaminledet",  new Continuation<List<Repo>>() {

            @Override
            public void resume(List<Repo> value) {
                Log.d("MainActivity", value.toString());
            }

            @Override
            public void resumeWithException(@Nullable  Throwable throwable) {
                Log.e("MainActivity", "getReposAsync", throwable);
            }
        });
    }
}
