package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.FragmentDoingBinding
import com.example.toptasks.ui.adapter.TaskAdapter

class DoingFragment : Fragment() {

  private var _binding: FragmentDoingBinding? = null
  private val binding get() = _binding!!

  private lateinit var taskAdapter: TaskAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDoingBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initRecyclerView(generateFakeTasks())
  }

  private fun initRecyclerView(taskList: List<Task>) {
    taskAdapter = TaskAdapter(taskList)

    binding.fragmentDoingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.fragmentDoingRecyclerView.setHasFixedSize(true)
    binding.fragmentDoingRecyclerView.adapter = taskAdapter
  }

  private fun generateFakeTasks() = listOf(
    Task("0", "Criar task", Status.DOING),
    Task("1", "Alterar uma task", Status.DOING),
    Task("2", "Comprar pão", Status.DOING),
    Task("3", "Fazer pudim", Status.DOING),
  )

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}