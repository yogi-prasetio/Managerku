package com.bangkit.capstone.managerku.ui.content.sales

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.databinding.ActivityAddSalesBinding

class AddSalesActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityAddSalesBinding
    private lateinit var viewModel: SalesViewModel
    private var listProduct = ArrayList<ProductEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this)[SalesViewModel::class.java]


//        var data: List<String> = List<ProductEntity
            viewModel.getProduct()?.observe(this, { product ->
                binding.spinProduct.adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_spinner_item,
                        listProduct
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                }
            })

        binding.spinProduct.setOnItemSelectedListener(this)

        binding.btnSubmit.setOnClickListener {
            addSales()
            val intent = Intent(this, SalesFragment::class.java)
            startActivity(intent)
        }
    }

    fun addSales(){
        val price = binding.edQty.text.toString().toInt()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (view == binding.spinProduct.selectedView){
            val product = binding.spinProduct.getSelectedItem().toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}