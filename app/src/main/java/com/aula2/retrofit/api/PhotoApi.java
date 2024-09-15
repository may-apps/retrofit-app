package com.aula2.retrofit.api;

import com.aula2.retrofit.model.Foto;
import com.aula2.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PhotoApi {
    @GET("photos")
    Call<List<Foto>> getPhotos();

    @GET("photos/{id}")
    Call<Foto> getById(@Path("id") String id);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @PUT("posts/{id}")
    Call<Post> updatePost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}
