package com.stepanov.studyschedule.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stepanov.studyschedule.databinding.LessonsForTheDayRecyclerItemBinding
import com.stepanov.studyschedule.domain.Lesson


class LessonsForTheDayRecyclerAdapter(
    private var data: List<Lesson> = listOf()
) :
    RecyclerView.Adapter<LessonsForTheDayRecyclerAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataNew: List<Lesson>) {
        this.data = dataNew
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LessonsForTheDayRecyclerItemBinding.inflate(
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
        fun bind(lesson: Lesson) {
            LessonsForTheDayRecyclerItemBinding.bind(itemView).apply {
                lessonNameTextView.text = lesson.name
                timeTextView.text = lesson.time
            }
        }
    }
}