package com.classy.class_2021a_andb_6;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

    @GET("movies")
    Call<List<Movie>> loadMovies();

    @GET("movies/{movieKey}")
    Call<Movie> loadMovieByKey(@Path(value = "movieKey", encoded = true) String _movieKey);


}
