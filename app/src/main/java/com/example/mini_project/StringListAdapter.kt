package com.example.mini_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StringListAdapter(private val context : Context , private val stringList : List<String>?) :
    RecyclerView.Adapter<StringListAdapter.StringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.diet_block, parent, false)
        return StringViewHolder(view)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val currentString = stringList?.get(position)
        if (currentString != null) {
            holder.bind(currentString)
        }
    }

    override fun getItemCount(): Int {
        return stringList!!.size
    }

    inner class StringViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.diet_textview)

        fun bind(string: String) {
            textView.text = string
        }
    }
}
