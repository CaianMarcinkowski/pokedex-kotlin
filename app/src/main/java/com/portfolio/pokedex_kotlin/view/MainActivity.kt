package com.portfolio.pokedex_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Chronometer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.pokedex_kotlin.R
import com.portfolio.pokedex_kotlin.api.PokemonRepository
import com.portfolio.pokedex_kotlin.api.model.PokemonApiResult
import com.portfolio.pokedex_kotlin.domain.Pokemon
import com.portfolio.pokedex_kotlin.domain.PokemonType
import com.portfolio.pokedex_kotlin.viewModel.PokemonViewModel
import com.portfolio.pokedex_kotlin.viewModel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
	  
	  private val recyclerView by lazy {
			findViewById<RecyclerView>(R.id.rvPokemons)
	  }
	  
	  val viewModel by lazy {
			ViewModelProvider(this, PokemonViewModelFactory()).get(PokemonViewModel::class.java)
	  }
	  
	  override fun onCreate(savedInstanceState: Bundle?) {
			super.onCreate(savedInstanceState)
			setContentView(R.layout.activity_main)
			
			recyclerView.layoutManager = LinearLayoutManager(this)
			
			viewModel.pokemons.observe(this, Observer {
				  loadRecyclerView(it)
			})
	  }
	  
	  private fun loadRecyclerView(pokemons: List<Pokemon?>) {
			recyclerView.layoutManager = LinearLayoutManager(this)
			recyclerView.adapter = PokemonAdapter(pokemons)
			
	  }
	  
}