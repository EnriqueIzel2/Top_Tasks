package com.example.toptasks.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.toptasks.databinding.FragmentRegisterBinding
import com.example.toptasks.utils.initToolbar

class RegisterFragment : Fragment() {

  private var _binding: FragmentRegisterBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentRegisterBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initToolbar(binding.toolbar)
    initListeners()
  }

  private fun initListeners() {
    binding.registerBtnCreateAccount.setOnClickListener {
      validateData()
    }
  }

  private fun validateData() {
    val email = binding.registerEditTextEmail.text.toString().trim()
    val password = binding.registerEditTextPassword.text.toString().trim()

    if (email.isNotEmpty()) {
      if (password.isNotEmpty()) {
        Toast.makeText(requireContext(), "Certo", Toast.LENGTH_SHORT).show()
      } else {
        Toast.makeText(requireContext(), "Preencha uma senha", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(requireContext(), "Preencha um email válido", Toast.LENGTH_SHORT).show()
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}