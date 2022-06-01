package com.dario.carrizo.gloaballogicchallenge.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dario.carrizo.gloaballogicchallenge.R
import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import com.dario.carrizo.gloaballogicchallenge.databinding.FragmentHomeBinding
import com.dario.carrizo.gloaballogicchallenge.ui.home.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), ProductAdapter.OnItemProductClickListener {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        setUpObserversAndGetData()
    }

    private fun setUpObserversAndGetData(){
        with(viewModel){
            //SetUp loading observer
            isLoading.observe(viewLifecycleOwner) {
                binding.progress.visibility = if (it) View.VISIBLE else View.GONE
            }
            //SetUp product observer
            products.observe(viewLifecycleOwner){
                loadRecyclerViewData(it)
            }
            // Getting Data
            getProducts()
        }
    }

    private fun loadRecyclerViewData(list: List<Products>){
        binding.recyclerView.let{
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = ProductAdapter(list, this)
        }

    }

    override fun onClick(item: Products) {

        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)
        findNavController().navigate(action)
    }
}