package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Verbos : AppCompatActivity() {
    private lateinit var tono1: MediaPlayer
    private lateinit var tono2: MediaPlayer
    private lateinit var tono3: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verbos)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        tono1 = MediaPlayer.create(this, R.raw.azul)
        tono2 = MediaPlayer.create(this, R.raw.amarillo)
        tono3 = MediaPlayer.create(this, R.raw.verde)

        val imageButton1: ImageButton = findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = findViewById(R.id.imgButton3)

        imageButton1.setOnClickListener {
            reproducirTono(tono1)
        }

        imageButton2.setOnClickListener {
            reproducirTono(tono2)
        }

        imageButton3.setOnClickListener {
            reproducirTono(tono3)
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
        tono1.release()
        tono2.release()
        tono3.release()
    }
}