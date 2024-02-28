// MainFragment.kt
package com.marisma.booklegacy.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.marisma.booklegacy.MainActivity
import com.marisma.booklegacy.R
import com.marisma.booklegacy.databinding.FragmentMainBinding
import java.util.Locale




class MainFragment : Fragment() {

    companion object {

        var usuario = ""
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            usuario = binding.userEditText.text.toString()

            val userName = binding.userEditText.text.toString()
            val bundle = Bundle().apply {
                putString("USER_NAME", userName)
            }

            val mA = requireActivity() as MainActivity
            mA.activarNav()
            findNavController().navigate(R.id.action_mainFragment2_to_menuFragment,bundle)

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
