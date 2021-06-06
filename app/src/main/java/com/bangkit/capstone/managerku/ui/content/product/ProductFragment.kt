package com.bangkit.capstone.managerku.ui.content.product

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.ProductFragmentBinding
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class ProductFragment : Fragment() {
    private var frgmntBinding: ProductFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    lateinit var database: ManagerkuDatabase

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
            val mIntent = Intent(context, AddProductActivity::class.java)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        database = context?.let { ManagerkuDatabase.getInstance(it) }!!
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        setupRecyclerView()

        if (activity != null) {
            val viewModel = ViewModelProvider(this,  factory)[ProductViewModel::class.java]
            val productAdapter = ProductAdapter()

            viewModel.getProduct()?.observe(viewLifecycleOwner, {
                if (it!=null) {
                    productAdapter.setProduct(it)
                } else {
                    binding.notifEmpty.visibility = View.VISIBLE
                    binding.notifEmpty.contentDescription = resources.getString(R.string.product_empty)
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

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}