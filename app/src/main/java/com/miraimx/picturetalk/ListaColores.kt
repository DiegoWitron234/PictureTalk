package com.miraimx.picturetalk

import android.content.res.Resources
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaColores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_colores)
        initRecyclerView()
    }
    private val coloresLista = listOf(
        ListaColor(R.mipmap.rojo),
        ListaColor(R.mipmap.azul),
        ListaColor(R.mipmap.verde),
        ListaColor(R.mipmap.amarillo),
        ListaColor(R.mipmap.rosa),
        )
    private val sonidos = mutableListOf<MediaPlayer>()
    private fun initRecyclerView(){
        val manager = LinearLayoutManager(this)
        val decoracion = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.rvColores)
        recyclerView.layoutManager = manager
        recyclerView.adapter = RecursosAdapter(coloresLista) {  }
        recyclerView.addItemDecoration(decoracion)
    }
    private fun reproducirTono(colores: ListaColor) {
        val tono = MediaPlayer.create(this, R.raw.tono)
        sonidos.add(tono)
        // Verifica si el audio ya está reproduciendo y, si es así, detén la reproducción y reinicia
        //Toast.makeText(this, lista, Toast.LENGTH_SHORT).show()
        if (tono.isPlaying) {
            tono.seekTo(0)
        } else {
            tono.start()
        }
    }
    data class ListaColor(val idColor: Int){

    }

    override fun onDestroy() {
        super.onDestroy()
        for (tono in sonidos){
            tono.release()
        }
    }

}