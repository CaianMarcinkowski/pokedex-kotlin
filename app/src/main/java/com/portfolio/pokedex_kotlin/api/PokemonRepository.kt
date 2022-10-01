package com.portfolio.pokedex_kotlin.api

import android.util.Log
import com.portfolio.pokedex_kotlin.api.model.PokemonApiResult
import com.portfolio.pokedex_kotlin.api.model.PokemonsApiResult
import com.portfolio.pokedex_kotlin.domain.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

	  private val service: PokemonService
	  
	  init {
			val retrofit = Retrofit.Builder()
				  .baseUrl("https://pokeapi.co/api/v2/")
				  .addConverterFactory(GsonConverterFactory.create())
				  .build()
			
			service = retrofit.create(PokemonService::class.java)
	  }

	  fun listPokemons(limit: Int = 151): PokemonsApiResult? {
			val call = service.listPokemons(limit)
			return call.execute().body()
	  }
	  
	  fun getPokemon(number: Int): PokemonApiResult? {
			val call = service.getPokemon(number)
			return call.execute().body()
	  }
}