package com.example.practica_t3_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.practica_t3_3.adapter.PokemoAdapter;
import com.example.practica_t3_3.entidades.Pokemon;
import com.example.practica_t3_3.service.PokemonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Log.i("MAIN_APP","INICIANDO SEGUNDA ACTIVIDAD");

        RecyclerView rv= findViewById(R.id.pokemon);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/pokemons/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service=retrofit.create(PokemonService.class);

        service.listas().enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                PokemoAdapter adapter=new PokemoAdapter(response.body());
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                Log.i("MAIN_APP", "no hubo comunicacion con el servidor");
            }
        });

    }
}