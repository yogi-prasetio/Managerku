package com.bangkit.capstone.managerku.ui.content.sales

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.data.Repository
import com.bangkit.capstone.managerku.data.local.room.ManagerkuDatabase
import com.bangkit.capstone.managerku.databinding.SalesFragmentBinding
import com.bangkit.capstone.managerku.viewmodel.ViewModelFactory

class SalesFragment : Fragment() {
    private var frgmntBinding: SalesFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    lateinit var database: ManagerkuDatabase
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

        database = context?.let { ManagerkuDatabase.getInstance(it) }!!
        val repo = Repository(database)
        val factory = ViewModelFactory(repo)

        if (activity != null) {
            val viewModel = ViewModelProvider(this, factory)[SalesViewModel::class.java]
            val salesAdapter = SalesAdapter()

            viewModel.getAllSales()?.observe(viewLifecycleOwner, {
                if (it!=null) {
                    salesAdapter.setSales(it)
                } else {
                    emptyData()
                }
            })

            with(binding.rvSales) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = salesAdapter
            }
        }
    }

    private fun emptyData() {
        binding.apply {
            descEmptyState.text = resources.getString(R.string.sales_empty)
            notifEmpty.visibility = VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}