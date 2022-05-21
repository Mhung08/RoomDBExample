package com.example.roomdbexample.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbexample.databinding.FragmentDashboardBinding
import com.example.roomdbexample.room.DB.AppDatabase
import com.example.roomdbexample.ui.dashboard.view.ProductAdapter
import com.example.roomdbexample.ui.dashboard.view.ProductModel
import kotlinx.coroutines.GlobalScope

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val dashboardViewModel : DashboardViewModel by viewModels {
        SampleViewModelFactory("test")
    }

    private lateinit var adapterProduct : ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val rcList : RecyclerView = binding.rcListProduct

        adapterProduct = ProductAdapter {
           when (it) {
               is ProductModel.Home -> Log.d("TAG home", it.name)
               is ProductModel.Fashion -> Log.d("TAG fashion", it.name)
               is ProductModel.NewModel   -> Log.d("TAG newmodel", it.name)
           }
        }

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        rcList.layoutManager = layoutManager
        rcList.adapter = adapterProduct

        dashboardViewModel.listProduct.observe(viewLifecycleOwner) {
            adapterProduct.submitList(it)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}