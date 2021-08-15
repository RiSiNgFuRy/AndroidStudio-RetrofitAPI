package com.example.retrofit_api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolder {
    @GET("mandi?lat=28.44108136&lon=77.0526054&ver=89&lang=hi&crop_id=10")
    Call<Items> getPost();
}

