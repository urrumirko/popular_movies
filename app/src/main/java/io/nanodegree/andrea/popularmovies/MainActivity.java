package io.nanodegree.andrea.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import io.nanodegree.andrea.popularmovies.api.GetMoviesTask;
import io.nanodegree.andrea.popularmovies.api.NetworkUtils;
import io.nanodegree.andrea.popularmovies.model.Movie;

public class MainActivity extends AppCompatActivity implements GetMoviesTask.MoviesResults {

    RecyclerView recyclerView;
    TextView errorView;
    View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_movies);
        errorView = findViewById(R.id.errorView);
        progressBar = findViewById(R.id.progress_bar);

        int spanCount = getSpanCount();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.movie_item_margin);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spanCount, spacingInPixels));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        new GetMoviesTask(this).execute(NetworkUtils.buildPopularMoviesUrl());
    }

    @Override
    public void onMoviesReady(List<Movie> movies) {
        if (movies.size() > 0) {
            recyclerView.setAdapter(new MoviesAdapter(this, movies));
            showContent();
        } else {
            showNoItems();
        }
    }

    @Override
    public void onError() {
        showError();
    }

    //Internal methods

    private int getSpanCount() {
        return getResources().getInteger(R.integer.span_count);
    }

    //Handle visibility of views
    private void showContent() {
        recyclerView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    private void showNoItems() {
        recyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        errorView.setText(R.string.no_results);
        progressBar.setVisibility(View.GONE);
    }

    private void showError() {
        recyclerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}