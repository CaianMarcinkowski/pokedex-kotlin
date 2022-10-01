package com.portfolio.pokedex_kotlin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class PokemonViewModelFactory : ViewModelProvider.Factory {

	  override fun <T : ViewModel> create(modelClass: Class<T>): T {
			return PokemonViewModel() as T
	  }
	  
}