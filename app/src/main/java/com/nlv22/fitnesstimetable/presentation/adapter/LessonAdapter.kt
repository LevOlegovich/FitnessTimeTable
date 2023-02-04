package com.nlv22.fitnesstimetable.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nlv22.fitnesstimetable.R

class LessonAdapter : RecyclerView.Adapter<LessonViewHolder>() {

    private var dataList = mutableListOf<DataModelByHolder>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val layout = when (viewType) {
            VIEW_HEADER -> R.layout.header_date
            VIEW_ITEM -> R.layout.item_lesson
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position]) {
            is DataModelByHolder.HeaderDate -> VIEW_HEADER
            is DataModelByHolder.ItemTraining -> VIEW_ITEM
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    /** Обновление данных RecyclerView **/
    fun submitList(data: List<DataModelByHolder>) {
        dataList.apply {
            clear()
            addAll(data)
            notifyDataSetChanged()
        }
    }

    companion object {
        const val VIEW_HEADER = 0
        const val VIEW_ITEM = 1
    }

}
