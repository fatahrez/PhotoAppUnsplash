package com.example.photoapp.networking;


import com.example.photoapp.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkService {
    @GET("photos/")
    Call<List<Photo>> getPhotos(@Query("client_id") String client_id);
}
