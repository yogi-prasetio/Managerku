package com.bangkit.capstone.managerku.ui.content.sales.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.databinding.ItemRowsDataBinding

class ProductSalesAdapter: RecyclerView.Adapter<ProductSalesAdapter.ProductViewHolder>() {
    private var listproductSales = ArrayList<SalesEntity>()

    fun setProductSales(product: List<SalesEntity>?) {
        if (product == null) return
        this.listproductSales.clear()
        this.listproductSales.addAll(product)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemsProductBinding = ItemRowsDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(itemsProductBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = listproductSales[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listproductSales.size

    class ProductViewHolder(private val binding: ItemRowsDataBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("WrongConstant", "SetTextI18n")
        fun bind(data: SalesEntity) {
            with(binding) {
                tvDataTitle.text = "Product Id: "+ data.id_product.toString()
                tvDataPrice.text = "Sales: "+ data.qty.toString()
            }
        }
    }
}