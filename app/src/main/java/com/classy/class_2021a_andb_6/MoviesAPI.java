package com.classy.class_2021a_andb_6;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {

    @GET("zNCtbRtV")
    Call<List<Movie>> loadMovies();


}
