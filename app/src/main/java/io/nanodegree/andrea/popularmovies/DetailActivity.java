package io.nanodegree.andrea.popularmovies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nanodegree.andrea.popularmovies.model.Movie;

/**
 * Created by Andrea Loddo (andrea@evenly.io) on 11.05.2018
 * for Evenly GmbH
 * <p>
 * Copyright (c) 2018 Evenly GmbH,
 * all rights reserved
 */
public class DetailActivity extends AppCompatActivity {

    public final static String MOVIE_EXTRA = "extra.movie";

    @BindView(R.id.image_iv)
    ImageView posterImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_activity);

        ButterKnife.bind(this);

        if (getIntent() != null && getIntent().hasExtra(MOVIE_EXTRA)) {
            Movie movie = (Movie) getIntent().getSerializableExtra(MOVIE_EXTRA);

            Picasso.get().load(movie.getImageThumbnailUrl()).into(posterImageView);

        }
    }
}
