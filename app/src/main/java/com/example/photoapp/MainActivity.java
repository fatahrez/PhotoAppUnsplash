package com.example.photoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.photoapp.adapter.RecyclerViewAdapter;
import com.example.photoapp.model.Photo;
import com.example.photoapp.networking.NetworkUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NetworkUtil.ApiInstance().getPhotos(Constants.API_KEY)
                .enqueue(new Callback<List<Photo>>() {
                    @Override
                    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        recyclerViewAdapter = new RecyclerViewAdapter(response.body());
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<Photo>> call, Throwable t) {
                        Log.e(TAG, "onFailure: ", t);
                    }
                });
    }
}