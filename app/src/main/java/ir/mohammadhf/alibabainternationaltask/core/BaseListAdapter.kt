package ir.mohammadhf.alibabainternationaltask.core

import androidx.recyclerview.widget.ListAdapter
import ir.mohammadhf.alibabainternationaltask.core.BaseDiffUtil

abstract class BaseListAdapter<T, VH : BaseViewHolder<T>>
    : ListAdapter<T, VH>(BaseDiffUtil<T>()) {

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(getItem(position))
}