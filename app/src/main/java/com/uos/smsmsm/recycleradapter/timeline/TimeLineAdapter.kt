package com.uos.smsmsm.recycleradapter.timeline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import com.uos.smsmsm.R
import com.uos.smsmsm.base.BaseAdapter
import com.uos.smsmsm.base.BaseHolder
import com.uos.smsmsm.data.TimeLineDTO
import com.uos.smsmsm.databinding.ItemTimelinePostBinding
import com.uos.smsmsm.viewmodel.ContentUtilViewModel
import java.lang.IllegalStateException

class TimeLineAdapter : BaseAdapter<TimeLineDTO>(TimeLineDiffCallback()) {

    init {
        setHasStableIds(true)
        println("으아아아아아아 $itemCount")
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder<out ViewDataBinding, TimeLineDTO> {
        val binding = ItemTimelinePostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TimeLineHolder(binding = binding)
    }

    override fun onBindViewHolder(
        holder: BaseHolder<out ViewDataBinding, TimeLineDTO>,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).content!!.timestamp!!.toLong()
    }




    private class TimeLineDiffCallback : DiffUtil.ItemCallback<TimeLineDTO> () {
        override fun areItemsTheSame(oldItem: TimeLineDTO, newItem: TimeLineDTO): Boolean {
            println("oldItem $oldItem")
            println("newItem $newItem")
            return oldItem.contentId!! == newItem.contentId!!
        }

        override fun areContentsTheSame(oldItem: TimeLineDTO, newItem: TimeLineDTO): Boolean {
            println("oldItem2 $oldItem")
            println("newItem2 $newItem")
            return oldItem.contentId!! == newItem.contentId!!
        }

    }
}