package com.miraimx.picturetalk

import android.annotation.SuppressLint
import android.content.res.Resources
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class ListaColores : AppCompatActivity() {

    private val sonidos = mutableListOf<MediaPlayer>()
    private lateinit var mAdView: AdView
    private var tono: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_colores)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoracion = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.rvColores)
        val recursosLista = mutableListOf<ListaRecursos>()
        val etiquetasRecursos = resources.getStringArray(R.array.coloresLista).toList()

        for (etiqueta in etiquetasRecursos) {
            recursosLista.add(ListaRecursos(etiqueta))
        }

        recyclerView.layoutManager = manager
        recyclerView.adapter = RecursosAdapter(recursosLista) { reproducirTono(it) }
        recyclerView.addItemDecoration(decoracion)
    }

    @SuppressLint("DiscouragedApi")
    private fun reproducirTono(recurso: ListaRecursos) {
        val nombreRecursos = recurso.nombreElemento
        val idRecurso = resources.getIdentifier(nombreRecursos, "raw", packageName)
        try {
            if (tono != null) {
                if (tono!!.isPlaying) {
                    tono!!.seekTo(0)
                } else {
                    tono!!.start()
                }
            } else {
                // Crear una nueva instancia si tono es nulo
                tono = MediaPlayer.create(this, idRecurso)
                sonidos.add(tono!!)
                tono!!.start()
            }
        } catch (_: Resources.NotFoundException) {}
    }

    override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    override fun onPause() {
        super.onPause()
        mAdView.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mAdView.destroy()
        for (tono in sonidos) {
            tono.release()
        }
    }
}