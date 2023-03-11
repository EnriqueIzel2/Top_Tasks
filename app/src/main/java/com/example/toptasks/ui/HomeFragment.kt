package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.toptasks.R
import com.example.toptasks.databinding.FragmentHomeBinding
import com.example.toptasks.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initTabs()
  }

  private fun initTabs() {
    val viewPageAdapter = ViewPagerAdapter(requireActivity())
    binding.viewPager.adapter = viewPageAdapter

    viewPageAdapter.addFragment(TodoFragment(), R.string.status_task_todo)
    viewPageAdapter.addFragment(DoingFragment(), R.string.status_task_doing)
    viewPageAdapter.addFragment(DoneFragment(), R.string.status_task_done)

    binding.viewPager.offscreenPageLimit = viewPageAdapter.itemCount

    TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
      tab.text = getString(viewPageAdapter.getTitle(position))
    }.attach()
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}