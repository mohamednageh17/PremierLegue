package com.example.premiumlegue.ui.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.DisplayedMatchModel
import com.example.premiumlegue.databinding.ItemDayBinding
import com.example.premiumlegue.utils.getDayOfWeek

class DayAdapter(private val onItemClick: (item: DisplayedMatchModel) -> Unit) : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<DisplayedMatchModel>()

    inner class ViewHolder(private val viewBinding: ItemDayBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.root.setOnClickListener {
                onItemClick(dataSet[adapterPosition])
            }
        }

        private val adapter by lazy { MatchAdapter(onItemClick = {}) }

        fun bind(item: DisplayedMatchModel) = with(viewBinding) {
            dayTV.text = item.date?.substringBefore("T")?.getDayOfWeek(itemView.context, "yyyy-MM-dd")
            dateTV.text = item.date?.substringBefore("T")
         adapter.addItems(item.matches?.toMutableList()?: mutableListOf())
          //  adapter.addItems(mutableListOf())
            itemsRv.adapter = adapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDayBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun addItems(items: MutableList<DisplayedMatchModel>) {
        dataSet.addAll(items)
        notifyItemRangeChanged(0, itemCount)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        dataSet.clear()
        notifyDataSetChanged()
    }

    fun isEmpty() = dataSet.isEmpty()
}
