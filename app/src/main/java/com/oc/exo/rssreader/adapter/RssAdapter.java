package com.oc.exo.rssreader.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.oc.exo.rssreader.R;
import com.oc.exo.rssreader.WebActivity;
import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

public class RssAdapter extends RecyclerView.Adapter<RssAdapter.MyViewHolder>{

    List<FakeNews> fakeNews = FakeNewsList.all;
    TextView textViewTitleRSS;
    FakeNews currentFakeNews;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        textViewTitleRSS.setText(fakeNews.get(position).title);
        currentFakeNews = fakeNews.get(position);
        holder.news = currentFakeNews;
    }

    @Override
    public int getItemCount() {
        return fakeNews.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        FakeNews news;

        public MyViewHolder(final View itemView) {
            super(itemView);

            textViewTitleRSS = (TextView)itemView.findViewById(R.id.tvTitleRSS);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), WebActivity.class);
                    intent.putExtra("TITLE", news.title);
                    intent.putExtra("HTML_CONTENT", news.htmlContent);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

}
