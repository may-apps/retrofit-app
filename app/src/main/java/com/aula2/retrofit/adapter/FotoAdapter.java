package com.aula2.retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula2.retrofit.R;
import com.aula2.retrofit.model.Foto;
import com.bumptech.glide.Glide;

import java.util.List;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {

    List<Foto> fotos;

    public FotoAdapter(List<Foto> fotos) {
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(com.aula2.retrofit.R.layout.item, parent, false);
        FotoViewHolder pvh = new FotoViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder holder, int position) {

        holder.albumView.setText(fotos.get(position).getAlbumId());
        holder.tituloView.setText(fotos.get(position).getTitle());

        String url = fotos.get(position).getThumbnailUrl();
        Glide.with(holder.fotoView.getContext()).asBitmap().load(url).into(holder.fotoView);
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {

        TextView albumView;
        TextView tituloView;
        ImageView fotoView;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);

            albumView = itemView.findViewById(R.id.album);
            tituloView = itemView.findViewById(R.id.titulo);
            fotoView = itemView.findViewById(R.id.foto);
        }
    }
}
