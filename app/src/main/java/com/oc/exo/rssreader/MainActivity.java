package com.oc.exo.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.exo.rssreader.adapter.RssAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewRSS;
    RecyclerView.ItemDecoration itemDecoration;
    RssAdapter rssAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rssAdapter = new RssAdapter();
        recyclerViewRSS = (RecyclerView)findViewById(R.id.rvRSS);
        recyclerViewRSS.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRSS.setAdapter(rssAdapter);

        // mise en place de style
        itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewRSS.addItemDecoration(itemDecoration);
    }
}
