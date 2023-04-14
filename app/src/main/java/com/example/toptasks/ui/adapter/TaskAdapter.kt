package com.example.toptasks.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toptasks.R
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.ItemTaskBinding

class TaskAdapter(
  private val context: Context,
  private val taskList: List<Task>,
  private val taskSelected: (Task, Int) -> Unit
) : ListAdapter<Task, TaskAdapter.ViewHolder>(DIFF_CALLBACK) {

  companion object {
    val SELECT_BACK: Int = 1
    val SELECT_REMOVE: Int = 2
    val SELECT_EDIT: Int = 3
    val SELECT_DETAILS: Int = 4
    val SELECT_NEXT: Int = 5

    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
      override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id && oldItem.description == newItem.description
      }

      override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem && oldItem.description == newItem.description
      }
    }
  }

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
    val btnDelete = holder.binding.itemTaskBtnDelete
    val btnEdit = holder.binding.itemTaskBtnEdit
    val btnDetails = holder.binding.itemTaskBtnDetails
    val task = taskList[position]

    holder.binding.itemTaskDescription.text = task.description

    setIndicators(task, holder)

    btnDelete.setOnClickListener { taskSelected(task, SELECT_REMOVE) }
    btnEdit.setOnClickListener { taskSelected(task, SELECT_EDIT) }
    btnDetails.setOnClickListener { taskSelected(task, SELECT_DETAILS) }
  }

  private fun setIndicators(task: Task, holder: ViewHolder) {
    val btnBack = holder.binding.itemTaskIcBack
    val btnNext = holder.binding.itemTaskIcForward

    when (task.status) {
      Status.TODO -> {
        btnBack.isVisible = false

        btnNext.setOnClickListener { taskSelected(task, SELECT_NEXT) }
      }

      Status.DOING -> {
        btnBack.setColorFilter(
          ContextCompat.getColor(context, R.color.status_todo_color)
        )

        btnNext.setColorFilter(
          ContextCompat.getColor(context, R.color.status_done_color)
        )

        btnBack.setOnClickListener { taskSelected(task, SELECT_BACK) }
        btnNext.setOnClickListener { taskSelected(task, SELECT_NEXT) }
      }

      Status.DONE -> {
        btnNext.isVisible = false

        btnBack.setOnClickListener { taskSelected(task, SELECT_BACK) }
      }
    }
  }

  override fun getItemCount() = taskList.size
}