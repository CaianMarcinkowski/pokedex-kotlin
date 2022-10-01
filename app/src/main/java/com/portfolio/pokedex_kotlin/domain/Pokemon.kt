package com.portfolio.pokedex_kotlin.domain

data class Pokemon (
	  val number: Int,
	  val name: String,
	  val types: List<PokemonType>
) {
	  val formattedName = name.capitalize()
	  val formattedNumber = number.toString().padStart(3, '0')
	  
	  val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$formattedNumber.png"
}

