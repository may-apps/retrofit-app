package com.aula2.retrofit;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.aula2.retrofit.adapter.FotoAdapter;
import com.aula2.retrofit.api.PhotoApi;
import com.aula2.retrofit.model.Foto;
import com.aula2.retrofit.model.Post;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity_getPhoto extends AppCompatActivity {
    private RecyclerView fotoRecyclerView;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_get_photo);

        fotoRecyclerView = findViewById(R.id.fotoRecyclerView);
        fotoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if (intent.getBooleanExtra("byId", false)) {
            chamarApiRetrofitById();
        } else {
            chamarApiRetrofit();
        }
    }

    private void chamarApiRetrofit() {

        // Criar a chamada para a API
        PhotoApi photoApi = retrofit.create(PhotoApi.class);
        Call<List<Foto>> call = photoApi.getPhotos();

        // Executar chamada assíncrona
        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Foto> photos = response.body();
                    // Atualizar RecyclerView
                    fotoRecyclerView.setAdapter(new FotoAdapter(photos));
                } else {
                    Log.e("ERRO", "Resposta falhou: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {
                Log.e("ERRO", t.getMessage());
            }
        });
    }

    private void chamarApiRetrofitById() {

        // Criar a chamada para a API
        PhotoApi photoApi = retrofit.create(PhotoApi.class);
        Call<Foto> call = photoApi.getById("12");

        // Executar chamada assíncrona
        call.enqueue(new Callback<Foto>() {
            @Override
            public void onResponse(Call<Foto> call, Response<Foto> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Foto photo = response.body();
                    // Atualizar RecyclerView
                    fotoRecyclerView.setAdapter(new FotoAdapter(Collections.singletonList(photo)));
                } else {
                    Log.e("ERRO", "Resposta falhou: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Foto> call, Throwable t) {
                Log.e("ERRO", t.getMessage());
            }
        });
    }


    private void updatePost() {
        Post postAtualizado = new Post();
        postAtualizado.setTitle("Título atualizado");
        postAtualizado.setBody("Conteúdo atualizado");
        postAtualizado.setUserId(1);

        PhotoApi photoApi = retrofit.create(PhotoApi.class);
        Call<Post> call = photoApi.updatePost(1, postAtualizado);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post post = response.body();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }
        });

    }

    public void deletePost() {
        PhotoApi photoApi = retrofit.create(PhotoApi.class);
        Call<Void> call = photoApi.deletePost(1);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });

    }
}
