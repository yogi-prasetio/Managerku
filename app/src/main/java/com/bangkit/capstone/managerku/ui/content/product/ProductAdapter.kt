package com.bangkit.capstone.managerku.ui.content.product

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.databinding.ItemRowsDataBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var listProduct = ArrayList<ProductEntity>()
    
    fun setProduct(product: List<ProductEntity>?) {
        if (product == null) return
        this.listProduct.clear()
        this.listProduct.addAll(product)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemsProductBinding = ItemRowsDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemsProductBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = listProduct[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listProduct.size

    class ProductViewHolder(private val binding: ItemRowsDataBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("WrongConstant", "SetTextI18n")
        fun bind(data: ProductEntity) {
            with(binding) {
                tvDataTitle.text = data.name
                tvDataPrice.text = "Rp." + data.price.toString()
            }
        }
    }
}