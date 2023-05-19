package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.databinding.ItemLessonBinding
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

class LessonViewHolder(private val binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, currentItem: Lesson) {
        with(binding){
            textViewColor.setBackgroundColor(Color.parseColor(currentItem.color))
            textViewStartTime.text = currentItem.startTime
            textViewEndTime.text = currentItem.endTime
            textViewLessonName.text = currentItem.name
            textViewLocation.text = currentItem.place
            textViewTrainerName.text = currentItem.trainerFullName
        }
    }

    companion object {

        fun from(parent: ViewGroup): LessonViewHolder {
            val binding = ItemLessonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return LessonViewHolder(binding)
        }
    }
}