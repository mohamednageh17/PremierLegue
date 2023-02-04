package com.example.premiumlegue.ui.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.MatchModel
import com.example.premiumlegue.R
import com.example.premiumlegue.databinding.ItemMatchBinding

object MatchStatus {
    const val FINISHED = "FINISHED"
    const val POSTPONED = "POSTPONED"
    const val SCHEDULED = "SCHEDULED"
    const val CANCELLED = "CANCELLED"
    const val LIVE_NOW = "LIVE NOW"
}

class MatchAdapter(private val onItemClick: (item: MatchModel) -> Unit) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    private val dataSet = mutableListOf<MatchModel>()

    inner class ViewHolder(private val viewBinding: ItemMatchBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        init {
            viewBinding.root.setOnClickListener {
                onItemClick(dataSet[adapterPosition])
            }
        }


        fun bind(item: MatchModel) = with(viewBinding) {
            dayTV.text = item.utcDate?.substringBefore("T")
            statusTV.text = item.status
            when (item.status) {
                MatchStatus.FINISHED -> statusTV.setBackgroundColor(itemView.context.getColor(R.color.status_finished_color))
                MatchStatus.POSTPONED -> statusTV.setBackgroundColor(itemView.context.getColor(R.color.red))
                MatchStatus.SCHEDULED -> statusTV.setBackgroundColor(itemView.context.getColor(R.color.purple_200))
                MatchStatus.CANCELLED -> statusTV.setBackgroundColor(itemView.context.getColor(R.color.teal_200))
                MatchStatus.LIVE_NOW -> statusTV.setBackgroundColor(itemView.context.getColor(R.color.teal_200))
            }
            homeTeamTV.text = item.homeTeam?.name
            awayTeamTV.text = item.awayTeam?.name
            scoreTV.text = when (item.status) {
                MatchStatus.FINISHED -> "${item.score?.fullTime?.homeTeam} - ${item.score?.fullTime?.awayTeam}"
                else -> item.utcDate?.substringAfter("T")?.substring(0, 5)
            }
            startAtTV.text =
                buildString {
                    append(itemView.context.getString(R.string.start_at))
                    append(" ")
                    append(item.utcDate?.substringAfter("T")?.substring(0, 5))
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMatchBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun addItems(items: MutableList<MatchModel>) {
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