package com.bangkit.capstone.managerku.ui.content.product

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.entity.ProductEntity
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivityAddProductBinding
import com.bangkit.capstone.managerku.ui.home.MainActivity
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private lateinit var viewModel: ProductViewModel
    private lateinit var database: ManagerkuDatabase

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
            addProduct()
        }
    }

    private fun addProduct(){
        val dialog = Dialog(this)
        val name = binding.edName.text.toString()
        val price = binding.edPrice.text.toString().toInt()
        val stok = binding.edStok.text.toString().toInt()

        val product = ProductEntity( name, price, stok)
        viewModel.addProduct(product)
        dialog.setContentView(R.layout.add_success)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogButton = dialog.findViewById<Button>(R.id.success_button)
        dialogButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
        dialog.show()
    }
}