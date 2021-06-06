package com.bangkit.capstone.managerku.ui.content.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.databinding.DashboardFragmentBinding
import com.bangkit.capstone.managerku.ui.content.product.ProductFragment
import com.bangkit.capstone.managerku.ui.content.sales.SalesFragment

class DashboardFragment : Fragment(){
    private var frgmntBinding: DashboardFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntBinding = DashboardFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        viewModel.getAllProduct()?.observe(viewLifecycleOwner, {
            binding.tvProductCount.text = it.size.toString()
        })

        binding.tvSalesCount.text = viewModel.getAllSales().toString()

        binding.product.setOnClickListener {
            Intent(context, ProductFragment::class.java).also {
                startActivity(it) }
        }

        binding.sales.setOnClickListener {
            Intent(context, SalesFragment::class.java).also {
                startActivity(it) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}