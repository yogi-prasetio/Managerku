package com.bangkit.capstone.managerku.ui.content.sales

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.databinding.ItemRowsDataBinding

class SalesAdapter: RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {
    private var listSales = ArrayList<SalesEntity>()
    
    fun setSales(sales: List<SalesEntity>?) {
        if (sales == null) return
        this.listSales.clear()
        this.listSales.addAll(sales)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalesViewHolder {
        val itemsSalesBinding = ItemRowsDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SalesViewHolder(itemsSalesBinding)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        val data = listSales[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listSales.size

    class SalesViewHolder(private val binding: ItemRowsDataBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("WrongConstant")
        fun bind(data: SalesEntity) {
            with(binding) {
                tvDataTitle.text = data.tanggal

                itemView.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailSalesActivity::class.java)
//                    intent.putExtra(DetailSalesActivity.EXTRA_DATA, data.id)
//                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}