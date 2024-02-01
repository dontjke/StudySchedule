package com.stepanov.studyschedule.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stepanov.studyschedule.databinding.HomeworkRecyclerItemBinding
import com.stepanov.studyschedule.domain.Homework


class HomeworkRecyclerAdapter(
    private var data: List<Homework> = listOf()
) :
    RecyclerView.Adapter<HomeworkRecyclerAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataNew: List<Homework>) {
        this.data = dataNew
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomeworkRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(homework: Homework) {
            HomeworkRecyclerItemBinding.bind(itemView).apply {
                homeworkNameTextView.text = homework.name
                timeOutTextView.text = homework.timeOut
                descriptionTextView.text = homework.description
            }
        }
    }
}