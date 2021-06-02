package com.bangkit.capstone.managerku.ui.content.product

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ProductFragmentBinding
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class ProductFragment : Fragment() {
    private var frgmntBinding: ProductFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    private lateinit var viewModel: ProductViewModel
    private lateinit var factory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        frgmntBinding = ProductFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntBinding!!.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.add) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        parentFragment?.let {
            viewModel = ViewModelProvider(it, factory)[ProductViewModel::class.java]
        }
        observeProduct()

    }

    private fun observeProduct() {
        if (activity != null) {
            val productAdapter = ProductAdapter()

            viewModel.getAllProduct()?.observe(viewLifecycleOwner, {
                if (it!=null) {
                    productAdapter.setProduct(it)
                }
            })

            with(binding.rvProduct) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = productAdapter
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvProduct.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductAdapter()
        }
    }

    private fun enableEmptyStateEmptyFavoriteMovie() {
        binding.icon.visibility = View.VISIBLE
        binding.icon.contentDescription = resources.getString(R.string.product_empty)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}