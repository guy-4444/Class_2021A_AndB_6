package com.classy.class_2021a_andb_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_downloadMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_downloadMovies = findViewById(R.id.main_BTN_downloadMovies);
        main_BTN_downloadMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadStats();
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
        MovieController movieController = new MovieController();
        movieController.start();
    }
}