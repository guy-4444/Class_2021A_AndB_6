package com.classy.class_2021a_andb_6;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class GenericController implements Callback<ResponseBody> {

    private  CallBack_string callBack_string;

    public void downloadString(String url, CallBack_string callBack_string) {
        this.callBack_string = callBack_string;

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://a/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GenericAPI genericAPI = retrofit.create(GenericAPI.class);

        url = url.charAt(url.length()-1) == '/' ? url.substring(0, url.length()-1) : url;
        Call<ResponseBody> call = genericAPI.getData(url);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            try {
                String data = response.body().string();
                Log.d("pttt", "response: " + data);
                if (callBack_string != null) {
                    callBack_string.stringReady(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (callBack_string != null) {
                    callBack_string.stringReady(null);
                }
            }
        } else {
            System.out.println(response.errorBody());
            if (callBack_string != null) {
                callBack_string.stringReady(null);
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        t.printStackTrace();
    }

    public interface GenericAPI {
        @GET
        Call<ResponseBody> getData(@Url String url);
    }

    public interface CallBack_string {
        void stringReady(String str);
    }

}
