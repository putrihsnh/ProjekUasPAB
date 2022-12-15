package com.if3b.projekpab;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder> {
    private ArrayList<ModeMixue> alamatMixue;
    private Context ctx;


    public AdapterCard(ArrayList<ModeMixue> alamatMixue, Context ctx) {
        this.alamatMixue = alamatMixue;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        ModeMixue alamat = alamatMixue.get(position);
        holder.tvDataAlamat.setText(alamat.getDataAlamat());
        holder.tvTentang.setText(alamat.getTentang());
        Glide
                .with(ctx)
                .load(alamat.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xNama, xTentang, xFoto;
                xNama = alamat.getNama();
                xTentang =alamat.getTentang();
                xFoto = alamat.getFoto();

                Log.d( "onClick:", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
         {return(alamatMixue).size();}
    }
    public class ClassViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvTentang, tvDataAlamat;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
            tvDataAlamat = itemView.findViewById(R.id.tv_DataAlamat);
        }
    }
}

