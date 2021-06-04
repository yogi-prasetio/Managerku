package com.bangkit.capstone.managerku.ui.content.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.capstone.managerku.databinding.DashboardFragmentBinding

class DashboardFragment : Fragment() {
    private var frgmntBinding: DashboardFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntBinding = DashboardFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllProduct()?.observe(viewLifecycleOwner, {
            if (it.size != null) {
                binding.tvProductCount.text = it.size.toString()
            } else {
                binding.tvProductCount.text = "-"
            }
        })

        viewModel.getAllSales()?.observe(viewLifecycleOwner, {
            if (it.size != null) {
                binding.tvSalesCount.text = it.size.toString()
            } else {
                binding.tvSalesCount.text = "-"
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}