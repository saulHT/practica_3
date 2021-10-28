package com.example.practica_t3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.practica_t3_3.entidades.Pokemon;
import com.example.practica_t3_3.service.PokemonService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CapturarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);


         Button bt=findViewById(R.id.but_guarda);
         bt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                     Retrofit retrofit = new Retrofit.Builder()
                             .baseUrl("https://upn.lumenes.tk/pokemons/")
                             .addConverterFactory(GsonConverterFactory.create())
                             .build();

                      PokemonService service=retrofit.create(PokemonService.class);

                      Pokemon pokemon=new Pokemon();
                      pokemon.setNombre("PikaChu");
                      pokemon.setTipo("Electrico");
                      pokemon.setUrl_imagen("https://static.wikia.nocookie.net/amiibopedia/images/7/77/Pikachu.png/revision/latest?cb=20200411072802&path-prefix=es");
                      pokemon.setLatitude(-9.2973253);
                      pokemon.setLongitude(-76.0044342);

                      service.create(pokemon).enqueue(new Callback<Pokemon>() {
                          @Override
                          public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                              Log.i("MAIN_APP",new Gson().toJson(response.body()));
                          }

                          @Override
                          public void onFailure(Call<Pokemon> call, Throwable t) {
                              Log.i("MAIN_APP","No se puede establecer comunicacion con el API");
                          }
                      });

             }
         });
    }
}