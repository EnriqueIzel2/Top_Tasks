package com.example.toptasks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toptasks.R
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.FragmentTodoBinding
import com.example.toptasks.ui.adapter.TaskAdapter
import com.example.toptasks.ui.adapter.TaskTopAdapter

class TodoFragment : Fragment() {

  private var _binding: FragmentTodoBinding? = null
  private val binding get() = _binding!!

  private lateinit var taskAdapter: TaskAdapter
  private lateinit var taskTopAdapter: TaskTopAdapter

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

    initRecyclerView()
    generateFakeTasks()
  }

  private fun initNavigationListeners() {
    binding.todoFabCreateTask.setOnClickListener {
      findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
    }
  }

  private fun initRecyclerView() {
    val recyclerView = binding.fragmentTodoRecyclerView

    taskTopAdapter = TaskTopAdapter { task, option ->
      optionSelected(task, option)
    }

    taskAdapter = TaskAdapter(requireContext()) { task, option ->
      optionSelected(task, option)
    }

    val concatAdapter = ConcatAdapter(taskTopAdapter, taskAdapter)

    recyclerView.layoutManager = LinearLayoutManager(requireContext())
    recyclerView.setHasFixedSize(true)
    recyclerView.adapter = concatAdapter
  }

  private fun optionSelected(task: Task, option: Int) {
    when (option) {
      TaskAdapter.SELECT_REMOVE -> {
        Toast.makeText(requireContext(), "Deletando", Toast.LENGTH_SHORT).show()
      }

      TaskAdapter.SELECT_EDIT -> {
        Toast.makeText(requireContext(), "Editando", Toast.LENGTH_SHORT).show()
      }

      TaskAdapter.SELECT_DETAILS -> {
        Toast.makeText(requireContext(), "Editando", Toast.LENGTH_SHORT).show()
      }

      TaskAdapter.SELECT_NEXT -> {
        Toast.makeText(requireContext(), "Proximo", Toast.LENGTH_SHORT).show()
      }
    }
  }


  private fun generateFakeTasks() {
    val taskTopList = listOf(
      Task("0", "Tarefa do topo", Status.TODO),
    )

    val taskList = listOf(
      Task("0", "Criar task", Status.TODO),
      Task("1", "Alterar uma task", Status.TODO),
      Task("2", "Comprar pão", Status.TODO),
      Task("3", "Fazer pudim", Status.TODO),
    )

    taskTopAdapter.submitList(taskTopList)
    taskAdapter.submitList(taskList)
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}