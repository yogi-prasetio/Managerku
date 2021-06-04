package com.bangkit.capstone.managerku.ui.content.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        binding.btnSubmit.setOnClickListener {
            addProduct()
            Intent(this, ProductFragment::class.java).also { startActivity(it) }
        }
    }

    fun addProduct(){
        val name = binding.edName.text.toString()
        val price = binding.edPrice.text.toString().toInt()
        viewModel.addProduct(taskId, name, price)
    }
}