package com.example.luis.testcontetprovider.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.luis.testcontetprovider.Model.News;
import com.example.luis.testcontetprovider.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by luis on 14/12/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ListViewHolder>  {

    private final List<News> newsList;
    private final Context context;

    public NewsAdapter(Context context, List<News> newsList ) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getItemCount() {
        return this.newsList != null ? this.newsList.size() : 0;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Infla a view do layout
        View view = LayoutInflater.from(context).inflate(R.layout.news_adapter, viewGroup, false);

        // Cria o ViewHolder
        ListViewHolder holder = new ListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, final int position) {
        // Atualiza a view
        News news = newsList.get(position);

        holder.tTitle.setText(news.getTitle());
        holder.tDescription.setText(Html.fromHtml(news.getDescription()));
        holder.progress.setVisibility(View.VISIBLE);

        try {
            Picasso.with(context).load(news.getImage()).memoryPolicy(MemoryPolicy.NO_CACHE).fit().into(holder.img, new Callback() {
                @Override
                public void onSuccess() {
                    holder.progress.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    holder.progress.setVisibility(View.GONE);
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        holder.cardView.setOnClickListener(sobreListener(news));

    }

    private View.OnClickListener sobreListener(final News news){

        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }

    // ViewHolder com as views
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView tTitle;
        public TextView tDescription;
        public ImageView img;
        public ProgressBar progress;
        public CardView cardView;

        public ListViewHolder(View view) {
            super(view);
            // Cria as views para salvar no ViewHolder
            tTitle = view.findViewById(R.id.textTitle);
            tDescription = view.findViewById(R.id.textDescription);
            img = view.findViewById(R.id.img);
            progress = view.findViewById(R.id.progressImg);
            cardView = view.findViewById(R.id.card_view);
        }
    }
}