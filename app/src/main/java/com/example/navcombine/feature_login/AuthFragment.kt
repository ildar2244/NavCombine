package com.example.navcombine.feature_login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navcombine.R
import com.example.navcombine.databinding.FragmentAuthBinding

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToPassword.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_restorePasswordFragment)
        }

        binding.btnIsAuth.setOnClickListener {
            Log.d("9999", "onViewCreated: CLICK AUTH FAKE")
            Toast.makeText(requireContext(), "CLICK AUTH FAKE", Toast.LENGTH_SHORT).show()
        }
    }
}