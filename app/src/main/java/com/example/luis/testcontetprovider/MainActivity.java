package com.example.luis.testcontetprovider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luis.testcontetprovider.Adapters.NewsAdapter;
import com.example.luis.testcontetprovider.Model.News;
import com.example.luis.testcontetprovider.Repository.NewsRepository;
import com.example.luis.testcontetprovider.Services.NewsService;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<News> newsList;
    private NewsAdapter newsAdapter;
    private NewsRepository repository;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;
    private NewsAdapter newsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NewsService newsService = new NewsService(getApplicationContext());
        //newsService.dwnloadAll();

        recyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        repository = new NewsRepository(getApplicationContext());
        newsList = repository.findAllObject();
        newsListAdapter = new NewsAdapter(getApplicationContext(), newsList );
        recyclerView.setAdapter(newsListAdapter);

    }
}
