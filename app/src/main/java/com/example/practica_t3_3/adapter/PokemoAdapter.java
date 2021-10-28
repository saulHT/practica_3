package com.example.practica_t3_3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_t3_3.R;
import com.example.practica_t3_3.entidades.Pokemon;

import java.util.List;

public class PokemoAdapter extends RecyclerView.Adapter<PokemoAdapter.PokemoViewHolder>{

    private List<Pokemon>data;
    public  PokemoAdapter(List<Pokemon>data){
        this.data=data;
    }
    @NonNull
    @Override
    public PokemoViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,parent,false);
        return new PokemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PokemoViewHolder holder, int position) {
        TextView tv=holder.itemView.findViewById(R.id.text_nombre);
        TextView tx=holder.itemView.findViewById(R.id.text_tipo);
        Pokemon pokemon=data.get(position);

        tv.setText(pokemon.getNombre());
        tx.setText(pokemon.getTipo());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class PokemoViewHolder extends RecyclerView.ViewHolder{

        public PokemoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
