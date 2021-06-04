package com.bangkit.capstone.managerku.ui.content.sales

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.SalesFragmentBinding
import com.bangkit.capstone.managerku.ui.content.product.ProductAdapter

class SalesFragment : Fragment() {
    private var frgmntBinding: SalesFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntBinding = SalesFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntBinding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add) {
            val mIntent = Intent(context, AddSalesActivity::class.java)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setupRecyclerView()
        observeSales()
    }

    private fun observeSales() {

        if (activity != null) {
            val viewModel = ViewModelProvider(this)[SalesViewModel::class.java]
            val salesAdapter = SalesAdapter()

            viewModel.getAllSales()?.observe(viewLifecycleOwner, {
                if (it!=null) {
                    salesAdapter.setSales(it)
                } else {
                    binding.notifEmpty.visibility = View.VISIBLE
                    binding.notifEmpty.contentDescription = resources.getString(R.string.sales_empty)
                }
            })

            with(binding.rvSales) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = salesAdapter
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvSales.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}