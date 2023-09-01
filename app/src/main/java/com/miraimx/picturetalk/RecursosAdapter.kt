package com.miraimx.picturetalk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecursosAdapter(
    private val coloresLista: List<ListaColores.ListaColor>,
    private val onClickListener:
        (ListaColores.ListaColor) -> Unit
) : RecyclerView.Adapter<RecursosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecursosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecursosViewHolder(layoutInflater.inflate(R.layout.elementocolor, parent, false))
    }

    override fun getItemCount() = coloresLista.size

    override fun onBindViewHolder(holder: RecursosViewHolder, position: Int) {
        val item = coloresLista[position]
        holder.render(item, onClickListener)
    }

}
