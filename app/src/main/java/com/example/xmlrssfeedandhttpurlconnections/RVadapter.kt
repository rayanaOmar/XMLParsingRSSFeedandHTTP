package com.example.xmlrssfeedandhttpurlconnections

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlrssfeedandhttpurlconnections.databinding.EntryRowBinding
import com.example.xmlrssfeedandhttpurlconnections.model.Entry

class RVadapter(val entries: List<Entry>?) : RecyclerView.Adapter<RVadapter.ViewHolder>() {
    class ViewHolder (val binding: EntryRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EntryRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries!![position]

        holder.binding.apply {
            tvTitle.text = "Entry#${position+1}: ${entry.title}"
            tvName.text = "By: ${entry.author!!.name!!.substring(entry.author!!.name!!.lastIndexOf("/")+1)}"
            cardView.setOnClickListener {
                Toast.makeText(holder.itemView.context, tvName.text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = entries!!.size

}