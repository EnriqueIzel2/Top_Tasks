package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.FragmentDoneBinding
import com.example.toptasks.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {

  private var _binding: FragmentDoneBinding? = null
  private val binding get() = _binding!!

  private lateinit var taskAdapter: TaskAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDoneBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initRecyclerView(generateFakeTasks())
  }

  private fun initRecyclerView(taskList: List<Task>) {
    taskAdapter = TaskAdapter(requireContext(), taskList)

    binding.fragmentDoneRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.fragmentDoneRecyclerView.setHasFixedSize(true)
    binding.fragmentDoneRecyclerView.adapter = taskAdapter
  }

  private fun generateFakeTasks() = listOf(
    Task("0", "Criar task", Status.DONE),
    Task("1", "Alterar uma task", Status.DONE),
    Task("2", "Comprar pão", Status.DONE),
    Task("3", "Fazer pudim", Status.DONE),
  )

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}