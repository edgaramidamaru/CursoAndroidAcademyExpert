package com.questionary.brian.podcast.Retrofit.Usuarios;


import com.questionary.brian.podcast.models.UserJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Battl on 31/07/2017.
 */

public interface JsonPlaceService {

    @GET("/users")
    Call<List<UserJson>> getlistUsuarios();

    @GET("/users/{id}")
    Call<UserJson> getUser(@Path("id") String id);

//    @GET("/posts")
//    Call<List<Posts>> getListPosts();
//
//    @POST("/posts")
//    Call<String> postPosts();
//
//    @PUT("/posts/{id}")
//    Call<Posts> putPosts(@Path("id") String id);
//
//    @DELETE("/posts/{id}")
//    Call<Posts> deletePosts(@Path("id") String id);
//
//    @GET("/photos")
//    Call<List<Photos>> getListPhotos();

}
