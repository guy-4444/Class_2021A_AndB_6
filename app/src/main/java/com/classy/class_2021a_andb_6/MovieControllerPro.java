package com.classy.class_2021a_andb_6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieControllerPro {

    static final String BASE_URL = "https://dev-api.com/myMoviesApp/";

    private CallBack_Movie callBack_movie;
    private CallBack_Movies callBack_movies;

    Callback<List<Movie>> moviesArrayCallBack = new Callback<List<Movie>>() {
        @Override
        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
            if (response.isSuccessful()) {
                List<Movie> movies = response.body();

                if (callBack_movies != null) {
                    callBack_movies.movies(movies);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<List<Movie>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    Callback<Movie> movieCallBack = new Callback<Movie>() {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response) {
            if (response.isSuccessful()) {
                Movie movie = response.body();
                if (callBack_movie != null) {
                    callBack_movie.movie(movie);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t) {
            t.printStackTrace();
        }
    };

    public void fetchAllMovies(CallBack_Movies callBack_movies) {
        this.callBack_movies = callBack_movies;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);

        Call<List<Movie>> call = moviesAPI.loadMovies();
        call.enqueue(moviesArrayCallBack);
    }

    public void fetchMovieByKey(String key, CallBack_Movie callBack_movie) {
        this.callBack_movie = callBack_movie;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);

        Call<Movie> call = moviesAPI.loadMovieByKey(key);
        call.enqueue(movieCallBack);
    }

    public interface CallBack_Movies {
        void movies(List<Movie> movies);
    }

    public interface CallBack_Movie {
        void movie(Movie movie);
    }

}
