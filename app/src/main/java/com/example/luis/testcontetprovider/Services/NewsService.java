package com.example.luis.testcontetprovider.Services;

import android.content.Context;
import android.util.Log;

import com.example.luis.testcontetprovider.Model.News;
import com.example.luis.testcontetprovider.Repository.NewsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luis on 14/12/17.
 */

public class NewsService {

    private static String BSE_URL = "https://8c3784b6-71b5-4204-b3af-1cb67ac3c657.mock.pstmn.io";
    private NewsServiceInterface serviceInterface;
    final private Context appContext;

    public NewsService(Context appContext) {
        this.appContext = appContext;
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BSE_URL)
                .build();
        serviceInterface = retrofit.create(NewsServiceInterface.class);

    }


    public void dwnloadAll(){
        Call<List<News>> call = serviceInterface.getAll();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                NewsRepository repository = new NewsRepository(appContext , response.body());
                repository.insert();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO não sei o que fazer com essa merda
                Log.e(NewsService.class.getName() , t.getMessage() , t);
            }
        });
    }



}
