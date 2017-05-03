package com.example.janda_000.movies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int POSTER_ITEM_NUMBERS = 100;

    private PosterAdapter posterAdapter;
    private RecyclerView recyclerView;

    private Button detailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.poster_grid);

        GridLayoutManager gridLayout;

        gridLayout = new GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(gridLayout);

        recyclerView.setHasFixedSize(true);

        posterAdapter = new PosterAdapter(POSTER_ITEM_NUMBERS, MainActivity.this);

        recyclerView.setAdapter(posterAdapter);

        detailsButton = (Button) findViewById(R.id.details_button);

    }
}
