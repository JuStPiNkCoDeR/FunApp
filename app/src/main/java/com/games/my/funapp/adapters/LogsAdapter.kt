package com.games.my.funapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.games.my.funapp.R
import com.games.my.funapp.data.Log

class LogsAdapter: RecyclerView.Adapter<LogsAdapter.LogHolder>() {
    private var logs: List<Log> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.log_item, parent, false)
        return LogHolder(itemView)
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    override fun onBindViewHolder(holder: LogHolder, position: Int) {
        val currentLog: Log = logs[position]
        holder.textViewMessage.text = currentLog.message
        holder.textViewTime.text = currentLog.time
        holder.textViewId.text = currentLog.id.toString()
    }

    fun setLogs(logs: List<Log>) {
        this.logs = logs
        notifyDataSetChanged()
    }

    class LogHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewMessage: TextView = itemView.findViewById(R.id.text_log)
        val textViewTime: TextView = itemView.findViewById(R.id.text_log_time)
        val textViewId: TextView = itemView.findViewById(R.id.text_id)
    }
}