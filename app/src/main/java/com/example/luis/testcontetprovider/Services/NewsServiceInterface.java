package com.example.luis.testcontetprovider.Services;

import com.example.luis.testcontetprovider.Model.News;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by luis on 14/12/17.
 */

public interface NewsServiceInterface {

    @GET("news")
    Call<List<News>> getAll();

}
