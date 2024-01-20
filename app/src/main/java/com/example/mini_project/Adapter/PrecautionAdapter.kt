package com.example.mini_project.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mini_project.R

class PrecautionAdapter(private val context : Context,private val precautionList: List<String>) :
    RecyclerView.Adapter<PrecautionAdapter.PrecautionViewHolder>() {

    class PrecautionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val precautionName: TextView = itemView.findViewById(R.id.precaution_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrecautionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.precaution_block, parent, false)
        return PrecautionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PrecautionViewHolder, position: Int) {
        val currentPrecaution = precautionList[position]
        holder.precautionName.text = currentPrecaution
    }

    override fun getItemCount(): Int {
        return precautionList.size
    }
}
