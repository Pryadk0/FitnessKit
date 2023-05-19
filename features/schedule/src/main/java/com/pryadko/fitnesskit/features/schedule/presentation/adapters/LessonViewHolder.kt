package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.databinding.ItemLessonBinding
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

class LessonViewHolder(val binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, currentList: List<Lesson>) {
        with(binding){
            textViewColor.setBackgroundColor(Color.parseColor(currentList[position].color))
            textViewStartTime.text = currentList[position].startTime
            textViewEndTime.text = currentList[position].endTime
            textViewLessonName.text = currentList[position].name
            textViewLocation.text = currentList[position].place
            textViewTrainerName.text = currentList[position].trainerFullName
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