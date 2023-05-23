package com.example.parcial_moviles.ui.rest.newRest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial_moviles.databinding.FragmentNewRestBinding
import com.example.parcial_moviles.ui.rest.viewmodel.RestaurantViewModel

class NewRestaurantFragment : Fragment() {
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val restaurantViewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory
    }

    private lateinit var binding : FragmentNewRestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewRestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observerStatus()
    }

    private fun setViewModel(){
        binding.viewmodel= restaurantViewModel
    }

    private fun observerStatus(){
        restaurantViewModel.status.observe(viewLifecycleOwner) {
                status -> when{
            status.equals(RestaurantViewModel.WRONG_INFORMATION) -> {
                Log.d(APP_TAG, status)
                restaurantViewModel.clearStatus() }
            status.equals(RestaurantViewModel.RESTAURANT_CREATED) -> {
                Log.d(APP_TAG, status)
                Log.d(APP_TAG, restaurantViewModel.getRestaurant().toString())

                restaurantViewModel.clearStatus()
                findNavController().popBackStack() }
        }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}