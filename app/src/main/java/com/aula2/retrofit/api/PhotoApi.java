package com.aula2.retrofit.api;

import com.aula2.retrofit.model.Foto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PhotoApi {

    // Recuperando portal de teste: 5000 itens
//    Call porque é assíncrono
    @GET("photos")
    Call<List<Foto>> getPhotos();

    @GET("photos/{id}")
    Call<Foto> getById(@Path("id") String id);

//    @POST("posts")
//    Call<Postagem> salvarPostagem(@Body Postagem postagem);
}
