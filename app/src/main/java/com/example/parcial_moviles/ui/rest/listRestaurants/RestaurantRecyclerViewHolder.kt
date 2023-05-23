package com.example.parcial_moviles.ui.rest.listRestaurants

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_moviles.data.model.RestaurantModel
import com.example.parcial_moviles.databinding.ResttemBinding

class RestaurantRecyclerViewHolder(private val binding: ResttemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(restaurant : RestaurantModel, clickListener: (RestaurantModel) -> Unit){
        binding.nameTextView .text = restaurant.nombre
        binding.contenidoTextView.text = restaurant.tipoCocina

        binding.canalItemCardView.setOnClickListener{
            clickListener(restaurant)
        }
    }
}