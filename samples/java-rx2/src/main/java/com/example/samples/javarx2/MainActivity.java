package com.example.samples.javarx2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.core.Client;
import com.example.core.response.Repo;
import com.example.javarx2.RxSingleContinuation;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    Client client = new Client();

    Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Single<? super List<? extends Repo>> single = Single.create(emitter -> {
            client.getReposAsync("benjaminledet", new RxSingleContinuation(emitter));
        });

        disposable = single.subscribe(
                result -> {
                    Log.d("MainActivity", result.toString());
                },
                error ->  {
                    Log.e("MainActivity", "getReposAsync", error);
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
