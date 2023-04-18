package com.example.toptasks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.ItemTaskTopBinding

class TaskTopAdapter(
  private val taskTopSelected: (Task, Int) -> Unit
) : ListAdapter<Task, TaskTopAdapter.ViewHolder>(DIFF_CALLBACK) {

  companion object {
    val SELECT_REMOVE: Int = 2
    val SELECT_EDIT: Int = 3
    val SELECT_DETAILS: Int = 4

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
      override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id && oldItem.description == newItem.description
      }

      override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem && oldItem.description == newItem.description
      }
    }
  }

  inner class ViewHolder(val binding: ItemTaskTopBinding) : RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(
      ItemTaskTopBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      )
    )
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val btnDelete = holder.binding.itemTaskBtnDelete
    val btnEdit = holder.binding.itemTaskBtnEdit
    val btnDetails = holder.binding.itemTaskBtnDetails
    val task = getItem(position)

    holder.binding.itemTaskDescription.text = task.description

    btnDelete.setOnClickListener { taskTopSelected(task, SELECT_REMOVE) }
    btnEdit.setOnClickListener { taskTopSelected(task, SELECT_EDIT) }
    btnDetails.setOnClickListener { taskTopSelected(task, SELECT_DETAILS) }
  }
}