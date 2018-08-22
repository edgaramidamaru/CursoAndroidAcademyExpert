package com.questionary.brian.podcast.Retrofit.Usuarios;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Battl on 31/07/2017.
 */

public class JsonPlaceHolderApiService {

    public static JsonPlaceService API_SERVICE;

    public static JsonPlaceService getRetrofitUser(){
        String baseUrl = "https://jsonplaceholder.typicode.com";

        if (API_SERVICE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build();
            API_SERVICE = retrofit.create(JsonPlaceService.class);
        }

        return API_SERVICE;
    }

}
