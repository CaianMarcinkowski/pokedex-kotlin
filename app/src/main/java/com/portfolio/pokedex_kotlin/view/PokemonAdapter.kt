package com.portfolio.pokedex_kotlin.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.portfolio.pokedex_kotlin.R
import com.portfolio.pokedex_kotlin.domain.Pokemon

class PokemonAdapter(
	  private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
	  
	  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
			val view =
				  LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
			return ViewHolder(view)
	  }
	  
	  override fun getItemCount() = items.size
	  
	  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
			val item = items[position]
			
			holder.bindView(item)
	  }
	  
	  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
			
			fun bindView(item: Pokemon?) = with(itemView) {
				  val ivPokemon = findViewById<ImageView>(R.id.iv_pokemon)
				  val tvName = findViewById<TextView>(R.id.tv_name)
				  val tvNumber = findViewById<TextView>(R.id.tv_number)
				  val tvType1 = findViewById<TextView>(R.id.tv_type1)
				  val tvType2 = findViewById<TextView>(R.id.tv_type2)
				  
				  item?.let {
						Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)
					 
						tvNumber.text = "N° ${item.formattedNumber}"
						tvName.text = item.formattedName
						tvType1.text = item.types[0].name.capitalize()
					 
						if (item.types.size > 1) {
							  tvType2.visibility = View.VISIBLE
							  tvType2.text = item.types[1].name.capitalize()
						} else {
							  tvType2.visibility = View.GONE
						}
				  }
				  
			}
			
	  }
}