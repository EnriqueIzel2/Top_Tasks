package com.example.toptasks.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.toptasks.R
import com.example.toptasks.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

  private var _binding: FragmentLoginBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentLoginBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initListenersAndNavigation()
  }

  private fun initListenersAndNavigation() {
    binding.btnLogin.setOnClickListener {
      handleNavigation()
    }

    binding.loginCreateAccount.setOnClickListener {
      navToCreateAccount()
    }

    binding.loginRecoverAccount.setOnClickListener {
      navToRecoverAccount()
    }
  }

  private fun handleNavigation() {
    val email = binding.loginEditTextEmail.text.toString().trim()
    val password = binding.loginEditTextPassword.text.toString().trim()

    if (email.isNotEmpty()) {
      if (password.isNotEmpty()) {
        navToHome()
      } else {
        Toast.makeText(requireContext(), "Digite sua senha", Toast.LENGTH_SHORT).show()
      }
    } else {
      Toast.makeText(requireContext(), "Digite seu email", Toast.LENGTH_SHORT).show()
    }
  }

  private fun navToHome() {
    findNavController().navigate(R.id.action_global_homeFragment)
  }

  private fun navToCreateAccount() {
    findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
  }

  private fun navToRecoverAccount() {
    findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}