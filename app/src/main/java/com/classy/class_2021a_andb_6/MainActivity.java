package com.classy.class_2021a_andb_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_downloadMovies;
    private MaterialButton main_BTN_downloadMovie1;
    private MaterialButton main_BTN_downloadMovie2;
    private MaterialTextView main_LBL_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_downloadMovies = findViewById(R.id.main_BTN_downloadMovies);
        main_BTN_downloadMovie1 = findViewById(R.id.main_BTN_downloadMovie1);
        main_BTN_downloadMovie2 = findViewById(R.id.main_BTN_downloadMovie2);
        main_LBL_info = findViewById(R.id.main_LBL_info);
        main_BTN_downloadMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadMovies();
            }
        });
        main_BTN_downloadMovie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadMovie("m001");
            }
        });
        main_BTN_downloadMovie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadMovie("m002");
            }
        });
    }


    private void downloadStats() {
        final String BASE_URL = "https://pastebin.com/raw/T67TVJG9/";
        new GenericController().downloadString(BASE_URL, new GenericController.CallBack_string() {
            @Override
            public void stringReady(String str) {
                Log.d("pttt", "str = " + str);
            }
        });
    }

    private void downloadMovies() {
        new MovieControllerPro().fetchAllMovies(new MovieControllerPro.CallBack_Movies() {
            @Override
            public void movies(List<Movie> movies) {
                main_LBL_info.setText("Movies Size = " + movies.size());
            }
        });
    }

    private void downloadMovie(String key) {
        new MovieControllerPro().fetchMovieByKey(key, new MovieControllerPro.CallBack_Movie() {
            @Override
            public void movie(Movie movie) {
                main_LBL_info.setText("Movie = " + movie.getName());
            }
        });
    }
}