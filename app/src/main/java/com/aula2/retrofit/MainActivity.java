package com.aula2.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aula2.retrofit.api.PhotoApi;
import com.aula2.retrofit.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button getAllPhotos;
    Button getId;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllPhotos = findViewById(R.id.getAllPhotos);
        getId = findViewById(R.id.getIdPhoto);

        getAllPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_getPhoto.class);
                startActivity(intent);
            }
        });

        Button post = findViewById(R.id.postFeeds);
        post.setOnClickListener(v -> {
                Post novaPostagem = new Post();
                novaPostagem.setTitle("Título da nova postagem");
                novaPostagem.setBody("Conteúdo da postagem");
                novaPostagem.setUserId(1);

                PhotoApi photoApi = retrofit.create(PhotoApi.class);
                Call<Post> call = photoApi.createPost(novaPostagem);
                call.enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if (response.isSuccessful()) {
                            Post postCriado = response.body();
                            Toast.makeText(getApplicationContext(), ""+postCriado, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                    }
                });
        });

        getId.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity_getPhoto.class).putExtra("byId", true)));
    }
}