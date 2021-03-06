package io.nanodegree.andrea.popularmovies.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(@SerializedName("id") val id: String?,
                 @SerializedName("title") val originalTitle: String?,
                 @SerializedName("overview") val plotSynopsis: String?,
                 @SerializedName("vote_average") val userRating: String?,
                 @SerializedName("release_date") val releaseDate: String?,
                 @field:SerializedName("poster_path") val imageThumbnailUrl: String?) : Serializable {

    fun getFormattedImageThumbnailUrl(): String = "http:/image.tmdb.org/t/p/w500$imageThumbnailUrl"
}
