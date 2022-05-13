package com.example.retrofit18022022;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("KhoaPhamTraining/json/tien/demo1.json")
    Call<Demo1> fetchDemo1();

    @GET("KhoaPhamTraining/json/tien/demo2.json")
    Call<Demo2> fetchDemo2();
}
