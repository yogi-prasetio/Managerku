package com.bangkit.capstone.managerku.ui.content.sales

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.capstone.managerku.data.local.entity.DataEntity
import com.bangkit.capstone.managerku.databinding.ItemRowsDataBinding
import com.bangkit.capstone.managerku.ui.content.sales.detail.DetailSalesActivity

class SalesAdapter: RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {
    private var listSales = ArrayList<DataEntity>()
    
    fun setSales(sales: List<DataEntity>?) {
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
        fun bind(data: DataEntity) {
            with(binding) {
                tvDataTitle.text = data.date
                tvDataDesc.text = data.qty.toString()

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailSalesActivity::class.java)
                    intent.putExtra(DetailSalesActivity.EXTRA_DATA, data.date)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}