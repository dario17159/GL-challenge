package com.dario.carrizo.gloaballogicchallenge.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dario.carrizo.gloaballogicchallenge.R
import com.dario.carrizo.gloaballogicchallenge.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        Glide.with(requireContext())
            .load(args.product.image)
            .placeholder(R.drawable.progress_animation)
            .error(R.drawable.image)
            .into(binding.image)

        binding.title.text = args.product.title

        binding.description.text = args.product.description

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}