package ir.mohammadhf.alibabainternationaltask.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(private val rootView: View) :
    RecyclerView.ViewHolder(rootView) {

    abstract fun bind(item: T)
}