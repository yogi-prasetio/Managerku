package com.bangkit.capstone.managerku.ui.content.product

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.*
import androidx.fragment.app.Fragment
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ProductFragmentBinding

class ProductFragment : Fragment() {
    private var frgmntBinding: ProductFragmentBinding? = null
    private val binding get() = frgmntBinding!!

    private lateinit var viewModel: ProductViewModel

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

    override fun onDestroyView() {
        super.onDestroyView()
        frgmntBinding = null
    }
}