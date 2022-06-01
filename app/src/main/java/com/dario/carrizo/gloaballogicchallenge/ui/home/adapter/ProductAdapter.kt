package com.dario.carrizo.gloaballogicchallenge.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dario.carrizo.gloaballogicchallenge.R
import com.dario.carrizo.gloaballogicchallenge.core.BaseViewHolder
import com.dario.carrizo.gloaballogicchallenge.data.model.Products
import com.dario.carrizo.gloaballogicchallenge.databinding.ProductItemBinding

/**
 * @author Dario Carrizo on 01/06/2022
 **/
class ProductAdapter(private val itemList: List<Products>, private val onItemClick: OnItemProductClickListener) : RecyclerView
.Adapter<BaseViewHolder<*>>() {

    interface OnItemProductClickListener{
        fun onClick(item: Products)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ProductViewHolder -> {
                holder.bind(itemList[position])
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    private inner class ProductViewHolder(private val binding: ProductItemBinding,private val context: Context): BaseViewHolder<Products>(binding
        .root){
        override fun bind(item: Products) {

            // Load picture
            Glide.with(context)
                .load(item.image)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.image)
                .into(binding.image)

            binding.title.text = item.title
            binding.description.text = item.description

            binding.moreDetailButton.setOnClickListener {
                onItemClick.onClick(item)
            }
        }
    }

}