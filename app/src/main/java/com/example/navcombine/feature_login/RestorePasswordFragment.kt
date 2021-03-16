package com.example.navcombine.feature_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navcombine.databinding.FragmentRestorePasswordBinding

class RestorePasswordFragment : Fragment() {

    private lateinit var binding: FragmentRestorePasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRestorePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }
}