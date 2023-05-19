package com.pryadko.fitnesskit.features.schedule.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pryadko.fitnesskit.features.schedule.domain.entities.Lesson
import java.lang.ClassCastException
import javax.inject.Inject

private const val ITEM_VIEW_TYPE_LESSON = 0
private const val ITEM_VIEW_TYPE_LESSON_WITH_DATE = 1

class LessonsListAdapter @Inject constructor( ) : ListAdapter<Lesson, RecyclerView.ViewHolder>(LessonItemDiffCallback()) {

    private var currentDate = ""

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).date != currentDate) {
            currentDate = getItem(position).date
            ITEM_VIEW_TYPE_LESSON_WITH_DATE
        } else ITEM_VIEW_TYPE_LESSON
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_LESSON -> LessonViewHolder.from(parent)
            ITEM_VIEW_TYPE_LESSON_WITH_DATE -> LessonWithDateViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is LessonViewHolder -> holder.bind(position, currentList)
            is LessonWithDateViewHolder -> holder.bind(position, currentList)
        }
    }
}