package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toptasks.R
import com.example.toptasks.databinding.FragmentFormTaskBinding

class FormTaskFragment : Fragment() {

  private var _binding: FragmentFormTaskBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}