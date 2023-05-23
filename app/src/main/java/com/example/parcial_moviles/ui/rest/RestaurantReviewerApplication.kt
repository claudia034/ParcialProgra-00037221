package com.example.parcial_moviles.ui.rest

import android.app.Application
import com.example.parcial_moviles.data.model.restaurant
import com.example.parcial_moviles.repository.RestaurantRepository

class RestaurantReviewerApplication: Application(){
    val restaurantRepository: RestaurantRepository by lazy {
        RestaurantRepository(restaurant)
    }
}