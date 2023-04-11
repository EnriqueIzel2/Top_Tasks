package com.example.toptasks.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toptasks.R
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.FragmentTodoBinding
import com.example.toptasks.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {

  private var _binding: FragmentTodoBinding? = null
  private val binding get() = _binding!!

  private lateinit var taskAdapter: TaskAdapter

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentTodoBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    initNavigationListeners()

    initRecyclerView(generateFakeTasks())
  }

  private fun initNavigationListeners() {
    binding.todoFabCreateTask.setOnClickListener {
      findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
    }
  }

  private fun initRecyclerView(taskList: List<Task>) {
    taskAdapter = TaskAdapter(requireContext(), taskList)

    binding.fragmentTodoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    binding.fragmentTodoRecyclerView.setHasFixedSize(true)
    binding.fragmentTodoRecyclerView.adapter = taskAdapter
  }

  private fun generateFakeTasks() = listOf(
    Task("0", "Criar task", Status.TODO),
    Task("1", "Alterar uma task", Status.TODO),
    Task("2", "Comprar pão", Status.TODO),
    Task("3", "Fazer pudim", Status.TODO),
  )

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}