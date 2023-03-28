package com.example.toptasks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.ItemTaskBinding

class TaskAdapter(
  private val taskList: List<Task>
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

  inner class ViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemTaskBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val task = taskList[position]
    holder.binding.itemTaskDescription.text = task.description
  }

  override fun getItemCount() = taskList.size
}