package com.example.retrofit18022022;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("KhoaPhamTraining/json/tien/demo1.json")
    Call<Demo1> fetchDemo1();

    @GET("KhoaPhamTraining/json/tien/demo2.json")
    Call<Demo2> fetchDemo2();

    @GET("KhoaPhamTraining/json/tien/demo4.json")
    Call<List<Demo4>> fetchDemo4();
}
