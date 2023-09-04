package com.miraimx.picturetalk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecursosAdapter(
    private val recursosLista: List<ListaRecursos>,
    private val onClickListener:
        (ListaRecursos) -> Unit
) : RecyclerView.Adapter<RecursosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecursosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecursosViewHolder(layoutInflater.inflate(R.layout.item_recycler, parent, false))
    }

    override fun getItemCount() = recursosLista.size

    override fun onBindViewHolder(holder: RecursosViewHolder, position: Int) {
        val item = recursosLista[position]
        holder.render(item, onClickListener)
    }
}
