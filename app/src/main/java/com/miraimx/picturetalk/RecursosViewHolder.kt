package com.miraimx.picturetalk

import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView


class RecursosViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val imagenRecurso = view.findViewById<ImageButton>(R.id.imgRecurso)

    fun render(
        atributo: ListaRecursos, onClickListener:
            (ListaRecursos) -> Unit
    ){
        val nombreRecurso = atributo.nombreElemento
        val idColor = itemView.resources.getIdentifier(nombreRecurso, "mipmap", itemView.context.packageName)
        imagenRecurso.setBackgroundResource(idColor)
        // Listener que asigna el sonido
        imagenRecurso.setOnClickListener { onClickListener(atributo)}
    }
}