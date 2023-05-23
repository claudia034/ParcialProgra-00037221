package com.example.parcial_moviles.ui.rest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial_moviles.data.model.RestaurantModel
import com.example.parcial_moviles.repository.RestaurantRepository
import com.example.parcial_moviles.RestaurantReviewerApplication

class RestaurantViewModel(private val repository: RestaurantRepository): ViewModel() {
    var nombre = MutableLiveData("")
    var tipoCocina = MutableLiveData("")
    var status = MutableLiveData("")
    fun getRestaurant() = repository.getRestaurant()

    fun addRestaurant(canal: RestaurantModel) = repository.addRestaurant(canal)
    fun createCanal(){
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val restaurant =RestaurantModel(
            nombre.value!!,
            tipoCocina.value!!,
        )
        addRestaurant(restaurant)
        clearData()

        status.value =  RESTAURANT_CREATED
    }

    private fun validateData(): Boolean {
        when {
            nombre.value.isNullOrEmpty() -> return false
            tipoCocina.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        nombre.value = ""
        tipoCocina.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }

    fun setSelectedCanal(restaurant: RestaurantModel){
        nombre.value = restaurant.nombre
        tipoCocina.value = restaurant.tipoCocina
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RestaurantReviewerApplication
                RestaurantViewModel(app.restaurantRepository)
            }
        }
        const val RESTAURANT_CREATED = "Restaurant created"
        const val WRONG_INFORMATION = "Wrong information"
        const val  INACTIVE = ""
    }
}