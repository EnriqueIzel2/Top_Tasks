package com.example.toptasks.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
      navToHome()
    }

    binding.loginCreateAccount.setOnClickListener {
      navToCreateAccount()
    }

    binding.loginRecoverAccount.setOnClickListener {
      navToRecoverAccount()
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