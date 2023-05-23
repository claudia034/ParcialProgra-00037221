package com.example.parcial_moviles.ui.rest.listRestaurants
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_moviles.R
import com.example.parcial_moviles.data.model.RestaurantModel
import com.example.parcial_moviles.databinding.FragmentListRestBinding
import com.example.parcial_moviles.ui.rest.viewmodel.RestaurantViewModel

class ListRestaurantFragment : Fragment(){
    private val restaurantViewModel: RestaurantViewModel by activityViewModels {
        RestaurantViewModel.Factory
    }
    private lateinit var adapter: RestaurantRecyclerViewAdapter

    private lateinit var binding: FragmentListRestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListRestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)
        binding.btnLinkNewCanal.setOnClickListener{
            restaurantViewModel.clearData()

            findNavController().navigate(R.id.action_listTVFragment2_to_newRestaurantFragment)

        }

    }
    private fun showSelectedItem(restaurant: RestaurantModel){
        restaurantViewModel.setSelectedCanal(restaurant)
        findNavController().navigate(R.id.action_listTVFragment2_to_restFragment)
    }

    private fun setRecyclerView(view: View){
        binding.recycleView.layoutManager = LinearLayoutManager(view.context)

        adapter = RestaurantRecyclerViewAdapter{ selectedCanal ->
            showSelectedItem(selectedCanal)
        }

        binding.recycleView.adapter = adapter
        displayRestaurant()
    }

    private fun displayRestaurant(){
        adapter.setData(restaurantViewModel.getRestaurant())
        adapter.notifyDataSetChanged()
    }

}