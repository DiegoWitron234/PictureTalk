package com.miraimx.picturetalk

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
        val coloresLista = mutableListOf<ListaRecursos>()
        val stringColor = resources.getStringArray(R.array.coloresLista).toList()

        for (color in stringColor) {
            coloresLista.add(ListaRecursos(color))
        }

        recyclerView.layoutManager = manager
        recyclerView.adapter = RecursosAdapter(coloresLista) { reproducirTono(it) }
        recyclerView.addItemDecoration(decoracion)
    }

    private fun reproducirTono(colores: ListaRecursos) {
        val nombreColor = colores.nombreElemento
        val idColor = resources.getIdentifier(nombreColor, "raw", packageName)
        try {
            val tono = MediaPlayer.create(this, idColor)
            sonidos.add(tono)
            if (tono.isPlaying) {
                tono.seekTo(0)
            } else {
                tono.start()
            }
        } catch (_: Resources.NotFoundException) {
        }
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