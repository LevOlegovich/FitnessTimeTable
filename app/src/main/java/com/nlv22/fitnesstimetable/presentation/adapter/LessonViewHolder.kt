package com.nlv22.fitnesstimetable.presentation.adapter

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nlv22.fitnesstimetable.R

class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /** Инит View заголовка или списка занятий**/
    fun bind(data: DataModelByHolder) {
        when (data) {
            is DataModelByHolder.HeaderDate -> bindHeader(data)
            is DataModelByHolder.ItemTraining -> bindItem(data)
        }
    }

    /** View даты (заголовка) **/
    private fun bindHeader(data: DataModelByHolder.HeaderDate) {
        val title: TextView = itemView.findViewById(R.id.dateTv)
        title.text = data.title
    }

    /** View занятий **/
    private fun bindItem(data: DataModelByHolder.ItemTraining) {
        val tabLessonTitle: TextView = findView(R.id.tabLessonTitle)
        val startTime: TextView = findView(R.id.startTimeTv)
        val endTime: TextView = findView(R.id.endTimeTv)
        val nameTrainer: TextView = findView(R.id.nameTrainerTv)
        val place: TextView = findView(R.id.placeTv)
        val colorLesson: ImageView = itemView.findViewById(R.id.colorLesson)

        data.lesson?.let {
            tabLessonTitle.text = it.tab
            startTime.text = it.startTime
            endTime.text = it.endTime
            place.text = it.place
            colorLesson.setBackgroundColor(Color.parseColor(it.color))
        }
        nameTrainer.text = data.trainer?.name
    }

    private fun findView(resId: Int): TextView = itemView.findViewById(resId)
}
