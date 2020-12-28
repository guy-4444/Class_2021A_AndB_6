package com.classy.class_2021a_andb_6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieController implements Callback<List<Movie>> {

    static final String BASE_URL = "https://pastebin.com/raw/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);

        Call<List<Movie>> call = moviesAPI.loadMovies();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        if (response.isSuccessful()) {
            List<Movie> changesList = response.body();
            int x = 0;
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Movie>> call, Throwable t) {
        t.printStackTrace();
    }
}
