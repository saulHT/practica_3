package com.example.practica_t3_3.service;

import com.example.practica_t3_3.entidades.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {

    @POST("n00025105/crear")
    Call<Pokemon> create(@Body Pokemon pokemon);

    @GET("n00025105")
    Call<List<Pokemon>> listas();
}
