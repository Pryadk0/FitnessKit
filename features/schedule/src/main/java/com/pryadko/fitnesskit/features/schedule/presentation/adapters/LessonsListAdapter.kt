package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import javax.inject.Inject


class LessonsListAdapter @Inject constructor() :
    ListAdapter<Lesson, RecyclerView.ViewHolder>(LessonItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).date == EMPTY_DATE)
            ITEM_VIEW_TYPE_LESSON
        else ITEM_VIEW_TYPE_LESSON_WITH_DATE


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            ITEM_VIEW_TYPE_LESSON -> LessonViewHolder.from(parent)
            ITEM_VIEW_TYPE_LESSON_WITH_DATE -> LessonWithDateViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonViewHolder -> holder.bind(position, currentList[position])
            is LessonWithDateViewHolder -> holder.bind(position, currentList[position])
        }
    }

    companion object {

        const val ITEM_VIEW_TYPE_LESSON = 0
        const val ITEM_VIEW_TYPE_LESSON_WITH_DATE = 1
        private const val EMPTY_DATE = ""

    }
}