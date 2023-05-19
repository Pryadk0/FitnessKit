package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.databinding.ItemLessonWithDateBinding
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

class LessonWithDateViewHolder(val binding: ItemLessonWithDateBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(position: Int, currentList: List<Lesson>) {
        with(binding){
            textViewColorWithDate.setBackgroundColor(Color.parseColor(currentList[position].color))
            textViewStartTimeWithDate.text = currentList[position].startTime
            textViewEndTimeWithDate.text = currentList[position].endTime
            textViewLessonNameWithDate.text = currentList[position].name
            textViewLocationWithDate.text = currentList[position].place
            textViewTrainerNameWithDate.text = currentList[position].trainerFullName
            textViewDate.text = currentList[position].date
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