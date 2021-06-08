package com.bangkit.capstone.managerku.ui.content.sales.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.capstone.managerku.data.local.entity.SalesEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivityDetailSalesBinding

class DetailSalesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSalesBinding
    private lateinit var database: ManagerkuDatabase

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailSalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        database = ManagerkuDatabase.getInstance(this)

        val date = intent.getStringExtra(EXTRA_DATA)
        val data: LiveData<List<SalesEntity>>? = date?.let { database.managerkuDao().getDetailSales(it) }
        val salesAdapter = ProductSalesAdapter()

        data?.observe(this, {
            salesAdapter.setProductSales(it)
        })

        with(binding.rvDetailSales) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = salesAdapter
        }

    }
}