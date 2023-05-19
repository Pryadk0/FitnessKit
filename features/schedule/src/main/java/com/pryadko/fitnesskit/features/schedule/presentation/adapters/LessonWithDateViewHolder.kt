package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.databinding.ItemLessonWithDateBinding
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

class LessonWithDateViewHolder(private val binding: ItemLessonWithDateBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, currentItem: Lesson) {
        with(binding){
            textViewColorWithDate.setBackgroundColor(Color.parseColor(currentItem.color))
            textViewStartTimeWithDate.text = currentItem.startTime
            textViewEndTimeWithDate.text = currentItem.endTime
            textViewLessonNameWithDate.text = currentItem.name
            textViewLocationWithDate.text = currentItem.place
            textViewTrainerNameWithDate.text = currentItem.trainerFullName
            textViewDate.text = currentItem.date
        }
    }

    companion object {

        fun from(parent: ViewGroup): LessonWithDateViewHolder {
            val layoutInflater =LayoutInflater.from(parent.context)
            val binding = ItemLessonWithDateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return LessonWithDateViewHolder(binding)
        }
    }
}