package com.example.parcial_moviles.repository

import com.example.parcial_moviles.data.model.RestaurantModel

class RestaurantRepository (private val restaurants: MutableList<RestaurantModel>) {

    fun getRestaurant() = restaurants

    fun addRestaurant(restaurant: RestaurantModel) = restaurants.add(restaurant)
}