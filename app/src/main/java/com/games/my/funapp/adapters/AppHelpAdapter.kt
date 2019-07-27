package com.games.my.funapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.games.my.funapp.R
import com.games.my.funapp.data.apphelp.Help

class AppHelpAdapter: RecyclerView.Adapter<AppHelpAdapter.HelpHolder>() {
    private var helps: List<Help> = listOf()
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_help_item, parent, false)
        context = parent.context
        return HelpHolder(itemView)
    }

    override fun getItemCount(): Int {
        return helps.size
    }

    override fun onBindViewHolder(holder: HelpHolder, position: Int) {
        val currentHelp = helps[position]
        holder.name.text = context?.getString(currentHelp.name)
        holder.stub.layoutResource = currentHelp.layout
        holder.stub.inflate()
    }

    fun setHelps(items: List<Help>) {
        this.helps = items
        notifyDataSetChanged()
    }

    class HelpHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.app_help_name)
        val stub: ViewStub = itemView.findViewById(R.id.app_help_stub)
    }
}