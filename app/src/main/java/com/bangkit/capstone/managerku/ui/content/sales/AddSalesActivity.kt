package com.bangkit.capstone.managerku.ui.content.sales

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ActivityAddSalesBinding
import com.bangkit.capstone.managerku.ui.home.MainActivity
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*


class AddSalesActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityAddSalesBinding
    private lateinit var viewModel: SalesViewModel
    private lateinit var database: ManagerkuDatabase

    private var datePickerDialog: DatePickerDialog? = null
    private var dateFormatter: SimpleDateFormat? = null
    private lateinit var product_name: String
    private var productId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        database = ManagerkuDatabase.getInstance(this)
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        viewModel = ViewModelProvider(this, factory)[SalesViewModel::class.java]

        val spinAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            viewModel.getProduct()
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.spinProduct.adapter = spinAdapter
        binding.spinProduct.setOnItemSelectedListener(this)

        dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
        binding.edDate.setOnClickListener { showDateDialog() }

        binding.btnSubmit.setOnClickListener {
            addSales()
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (view == binding.spinProduct.selectedView){
            product_name = binding.spinProduct.getSelectedItem().toString()
            productId = database.managerkuDao().getIdByProductName(product_name)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) { }

    private fun addSales(){
        val dialog = Dialog(this)
        val qty = binding.edQty.text.toString().toInt()
        val date = binding.edDate.text.toString()
        viewModel.addSales(taskId, productId, qty, date)
        dialog.setContentView(R.layout.add_success)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val dialogButton = dialog.findViewById<Button>(R.id.success_button)
        dialogButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
        dialog.show()
    }

    private fun showDateDialog() {
        val newCalendar: Calendar = Calendar.getInstance()
        datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val newDate: Calendar = Calendar.getInstance()
                newDate.set(year, monthOfYear, dayOfMonth)
                binding.edDate.setText(dateFormatter?.format(newDate.getTime()))
            },
            newCalendar.get(Calendar.YEAR),
            newCalendar.get(Calendar.MONTH),
            newCalendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog!!.show()
    }
}