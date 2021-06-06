package com.bangkit.capstone.managerku.ui.content.product

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivityAddProductBinding
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: ProductViewModel
    lateinit var database: ManagerkuDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        database = ManagerkuDatabase.getInstance(this)
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        viewModel = ViewModelProvider(this, factory)[ProductViewModel::class.java]
        binding.btnSubmit.setOnClickListener {
            val name = binding.edName.text.toString()
            val price = binding.edPrice.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val product = ProductEntity(taskId, name, price)
                database.managerkuDao().addProduct(product)
            }
            Intent(this, ProductFragment::class.java).also { startActivity(it) }
        }
    }
}