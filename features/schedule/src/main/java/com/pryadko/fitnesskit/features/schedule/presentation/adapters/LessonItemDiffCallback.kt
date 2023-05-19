package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson

class LessonItemDiffCallback  : DiffUtil.ItemCallback<Lesson>() {

    override fun areItemsTheSame(oldItem: Lesson, newItem: Lesson): Boolean =
        (oldItem.date == newItem.date) && (oldItem.startTime == newItem.startTime)

    override fun areContentsTheSame(oldItem: Lesson, newItem: Lesson): Boolean =
        oldItem == newItem


}