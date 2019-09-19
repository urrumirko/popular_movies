package io.nanodegree.andrea.popularmovies

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.io.nanodegree.popularmovies.feature.movie.movieModule

class PopularMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@PopularMoviesApplication)
            modules(movieModule)
        }
    }
}