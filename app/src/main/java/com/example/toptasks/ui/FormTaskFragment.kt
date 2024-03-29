package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.toptasks.R
import com.example.toptasks.databinding.FragmentFormTaskBinding
import com.example.toptasks.utils.initToolbar
import com.example.toptasks.utils.showBottomSheet

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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initToolbar(binding.toolbar)
    initListeners()
  }

  private fun initListeners() {
    binding.formTaskBtnSaveTask.setOnClickListener {
      validateData()
    }
  }

  private fun validateData() {
    val description = binding.formTaskEditTextCreateTask.text.toString()

    if (description.isNotEmpty()) {
      Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
    } else {
      showBottomSheet(message = getString(R.string.fragment_formTask_warning_description))
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}