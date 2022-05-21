package com.example.roomdbexample.ui.dashboard.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbexample.R
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(val onItemClick: ((ProductModel) -> Unit)? ) : ListAdapter<ProductModel, ProductAdapter.ProductViewHolder>(DiffUtilItem()) {

    inner class ProductViewHolder (itemBinding: View) : RecyclerView.ViewHolder(itemBinding) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(adapterPosition))
            }
        }

        private fun bindFashion(item: ProductModel.Fashion) {
            itemView.tvNameProduct.text = item.name
        }

        private fun bindHome(item: ProductModel.Home) {
            itemView.tvNameProduct.text = item.name
        }

        private fun bindNewModel(item: ProductModel.NewModel) {
            itemView.tvNameProduct.text = item.name
        }

        fun binData(data: ProductModel) {
            when(data) {
                is ProductModel.Fashion -> bindFashion(data)
                is ProductModel.Home -> bindHome(data)
                is ProductModel.NewModel -> bindNewModel(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = when (viewType) {
            TYPE_HOME -> R.layout.product_item
            TYPE_FASHION -> R.layout.product_item
            TYPE_NEWMODEL -> R.layout.product_item
            else -> R.layout.product_item
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
            holder.binData(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is ProductModel.Home -> TYPE_HOME
            is ProductModel.Fashion -> TYPE_FASHION
            else -> TYPE_NEWMODEL
        }

    }

    class DiffUtilItem : DiffUtil.ItemCallback<ProductModel>(){
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
           return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        private const val TYPE_HOME = 0
        private const val TYPE_FASHION = 1
        private const val TYPE_NEWMODEL = 2
    }
}


