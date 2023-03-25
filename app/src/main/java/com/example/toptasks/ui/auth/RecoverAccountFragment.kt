package com.example.toptasks.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.toptasks.R
import com.example.toptasks.databinding.FragmentRecoverAccountBinding
import com.example.toptasks.utils.initToolbar
import com.example.toptasks.utils.showBottomSheet

class RecoverAccountFragment : Fragment() {

  private var _binding: FragmentRecoverAccountBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initToolbar(binding.toolbar)
    initListeners()
  }

  private fun initListeners() {
    binding.recoverAccountBtnReceiveLink.setOnClickListener {
      validateData()
    }
  }

  private fun validateData() {
    val email = binding.recoverAccountEditTextEmail.text.toString().trim()

    if (email.isNotEmpty()) {
      Toast.makeText(requireContext(), "Certo", Toast.LENGTH_SHORT).show()
    } else {
      showBottomSheet(message = getString(R.string.fragment_recoverAccount_warning_email))
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}