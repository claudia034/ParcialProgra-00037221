package com.example.parcial_moviles.ui.rest.listRestaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_moviles.data.model.RestaurantModel
import com.example.parcial_moviles.databinding.ResttemBinding

class RestaurantRecyclerViewAdapter (
    private val clickListener: (RestaurantModel) -> Unit
) : RecyclerView.Adapter<RestaurantRecyclerViewHolder>() {
    private val restaurants = ArrayList<RestaurantModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantRecyclerViewHolder {
        val binding = ResttemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantRecyclerViewHolder, position: Int) {
        val restaurants = restaurants[position]
        holder.bind(restaurants, clickListener)
    }


    fun setData(restaurantlist: List<RestaurantModel>){
        restaurants.clear()
        restaurants.addAll(restaurantlist)
    }
}
