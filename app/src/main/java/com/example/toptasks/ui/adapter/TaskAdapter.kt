package com.example.toptasks.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.toptasks.R
import com.example.toptasks.data.model.Status
import com.example.toptasks.data.model.Task
import com.example.toptasks.databinding.ItemTaskBinding

class TaskAdapter(
  private val context: Context,
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

    setIndicators(task, holder)
  }

  private fun setIndicators(task: Task, holder: ViewHolder) {
    when (task.status) {
      Status.TODO -> {
        holder.binding.itemTaskIcBack.isVisible = false
      }

      Status.DOING -> {
        holder.binding.itemTaskIcBack.setColorFilter(
          ContextCompat.getColor(context, R.color.status_todo_color)
        )

        holder.binding.itemTaskIcForward.setColorFilter(
          ContextCompat.getColor(context, R.color.status_done_color)
        )
      }

      Status.DONE -> {
        holder.binding.itemTaskIcForward.isVisible = false
      }
    }
  }

  override fun getItemCount() = taskList.size
}