package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Tiempo : AppCompatActivity() {
    private lateinit var amanecer: MediaPlayer
    private lateinit var anoche: MediaPlayer
    private lateinit var anio: MediaPlayer
    private lateinit var vielamanecer: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        amanecer = MediaPlayer.create(this, R.raw.tono)
        anoche = MediaPlayer.create(this, R.raw.tono2)
        anio = MediaPlayer.create(this, R.raw.tono3)
        vielamanecer = MediaPlayer.create(this, R.raw.tono)

        val imageButton1: ImageButton = findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = findViewById(R.id.imgButton3)

        imageButton1.setOnClickListener {
            reproducirTono(amanecer)
        }

        imageButton2.setOnClickListener {
            reproducirTono(anoche)
        }

        imageButton3.setOnClickListener {
            reproducirTono(anio)
        }
    }

    private fun reproducirTono(tono: MediaPlayer) {
        // Verifica si el audio ya está reproduciendo y, si es así, detén la reproducción y reinicia
        if (tono.isPlaying) {
            tono.seekTo(0)
        } else {
            tono.start()
        }
    }

    override fun onPause() {
        mAdView.pause()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()

        mAdView.destroy()
        // Libera los recursos de MediaPlayer cuando el fragmento se destruya para evitar pérdidas de memoria
        amanecer.release()
        anoche.release()
        anio.release()
    }
}