package com.example.retrofit18022022;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30 , TimeUnit.SECONDS)
                            .connectTimeout(30 ,TimeUnit.SECONDS)
                            .protocols(Arrays.asList(Protocol.HTTP_1_1))
                            .build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://khoapham.vn/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        callDemo4(apiService);

    }

    private void callDemo1(ApiService apiService) {
        Call<Demo1> fetchDemo1 = apiService.fetchDemo1();
        fetchDemo1.enqueue(new Callback<Demo1>() {
            @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
                Demo1 demo1 = response.body();
                Log.d("BBB", demo1.toString());
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {

            }
        });
    }

    private void callDemo2(ApiService apiService) {
        Call<Demo2> fetchDemo2 = apiService.fetchDemo2();
        fetchDemo2.enqueue(new Callback<Demo2>() {
            @Override
            public void onResponse(Call<Demo2> call, Response<Demo2> response) {
                Demo2 demo2 = response.body();
                Log.d("BBB", demo2.toString());
            }

            @Override
            public void onFailure(Call<Demo2> call, Throwable t) {

            }
        });
    }

    private void callDemo4(ApiService apiService) {
        Call<List<Demo4>> fetchDemo4 = apiService.fetchDemo4();
        fetchDemo4.enqueue(new Callback<List<Demo4>>() {
            @Override
            public void onResponse(Call<List<Demo4>> call, Response<List<Demo4>> response) {
                List<Demo4> demo4List = response.body();
                for (int i = 0; i < demo4List.size(); i++) {
                    Log.d("BBB",demo4List.get(i).toString());
                }
            }

            @Override
            public void onFailure(Call<List<Demo4>> call, Throwable t) {

            }
        });
    }
}
