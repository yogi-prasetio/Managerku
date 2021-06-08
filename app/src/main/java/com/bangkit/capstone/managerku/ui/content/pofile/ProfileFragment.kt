package com.bangkit.capstone.managerku.ui.content.pofile

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangkit.capstone.managerku.R
import com.bangkit.capstone.managerku.databinding.ProfileFragmentBinding
import com.bangkit.capstone.managerku.ui.content.SettingActivity

class ProfileFragment : Fragment() {
    private var frgmntBinding: ProfileFragmentBinding? = null
    private val binding get() = frgmntBinding!!
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frgmntBinding = ProfileFragmentBinding.inflate(layoutInflater, container, false)
        return frgmntBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        setHasOptionsMenu(true)

//        val email = arguments?.getString("email")
//        Toast.makeText(context, email, Toast.LENGTH_SHORT).show()

//        val data = arguments
////        if (data != null) {
////
////            val email = data.getString("email")
////            binding.edEmail.setText(email)
////            Toast.makeText(context, email, Toast.LENGTH_SHORT).show()
////        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.setting_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.setting) {
            val mIntent = Intent(context, SettingActivity::class.java)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}