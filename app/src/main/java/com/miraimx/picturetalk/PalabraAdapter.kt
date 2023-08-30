package com.miraimx.picturetalk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PalabraAdapter(private val palabras: List<String>, private val context: Context) :
    RecyclerView.Adapter<PalabraAdapter.PalabraViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PalabraViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_palabra, parent, false)
        return PalabraViewHolder(view)
    }

    override fun onBindViewHolder(holder: PalabraViewHolder, position: Int) {
        val palabra = palabras[position]
        holder.bind(palabra)
    }

    override fun getItemCount(): Int {
        return palabras.size
    }

    inner class PalabraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val palabraTextView: TextView = itemView.findViewById(R.id.palabraTextView)

        fun bind(palabra: String) {
            palabraTextView.text = palabra
        }
    }
}