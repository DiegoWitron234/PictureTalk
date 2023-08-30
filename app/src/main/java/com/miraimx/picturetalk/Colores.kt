package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Colores : AppCompatActivity() {

    //private lateinit var tono1: MediaPlayer
    //private lateinit var tono2: MediaPlayer
    //private lateinit var tono3: MediaPlayer

    private lateinit var tonoAmarillo: MediaPlayer
    private lateinit var tonoAzul: MediaPlayer
    private lateinit var tonoBlanco: MediaPlayer
    private lateinit var tonoCafe: MediaPlayer
    private lateinit var tonoCeleste: MediaPlayer
    private lateinit var tonoGris: MediaPlayer
    private lateinit var tonoGuinda: MediaPlayer
    private lateinit var tonoLila: MediaPlayer
    private lateinit var tonoMorado: MediaPlayer
    private lateinit var tonoAnaranjado: MediaPlayer
    private lateinit var tonoNegro: MediaPlayer
    private lateinit var tonoRojo: MediaPlayer
    private lateinit var tonoRosado: MediaPlayer
    private lateinit var tonoVerde: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colores)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        //tono1 = MediaPlayer.create(this, R.raw.tono)
        //tono2 = MediaPlayer.create(this, R.raw.tono2)
        //tono3 = MediaPlayer.create(this, R.raw.tono3)
        tonoAmarillo = MediaPlayer.create(this, R.raw.tono)
        tonoAzul = MediaPlayer.create(this, R.raw.tono)
        tonoBlanco = MediaPlayer.create(this, R.raw.tono)
        tonoCafe = MediaPlayer.create(this, R.raw.tono)
        tonoCeleste = MediaPlayer.create(this, R.raw.tono)
        tonoGris = MediaPlayer.create(this, R.raw.tono)
        tonoGuinda = MediaPlayer.create(this, R.raw.tono)
        tonoLila = MediaPlayer.create(this, R.raw.tono)
        tonoMorado = MediaPlayer.create(this, R.raw.tono)
        tonoAnaranjado = MediaPlayer.create(this, R.raw.tono)
        tonoNegro = MediaPlayer.create(this, R.raw.tono)
        tonoRojo = MediaPlayer.create(this, R.raw.tono)
        tonoRosado = MediaPlayer.create(this, R.raw.tono)
        tonoVerde = MediaPlayer.create(this, R.raw.tono)

        val imageButton1: ImageButton = findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = findViewById(R.id.imgButton3)
        val imageButton4: ImageButton = findViewById(R.id.imgButton4)
        val imageButton5: ImageButton = findViewById(R.id.imgButton5)
        val imageButton6: ImageButton = findViewById(R.id.imgButton6)
        val imageButton7: ImageButton = findViewById(R.id.imgButton7)
        val imageButton8: ImageButton = findViewById(R.id.imgButton8)
        val imageButton9: ImageButton = findViewById(R.id.imgButton9)
        val imageButton10: ImageButton = findViewById(R.id.imgButton10)
        val imageButton11: ImageButton = findViewById(R.id.imgButton11)
        val imageButton12: ImageButton = findViewById(R.id.imgButton12)
        val imageButton13: ImageButton = findViewById(R.id.imgButton13)
        val imageButton14: ImageButton = findViewById(R.id.imgButton14)

        imageButton1.setOnClickListener {
            reproducirTono(tonoAmarillo)
        }
        imageButton2.setOnClickListener {
            reproducirTono(tonoAzul)
        }
        imageButton3.setOnClickListener {
            reproducirTono(tonoBlanco)
        }
        imageButton4.setOnClickListener {
            reproducirTono(tonoCafe)
        }
        imageButton5.setOnClickListener {
            reproducirTono(tonoCeleste)
        }
        imageButton6.setOnClickListener {
            reproducirTono(tonoGris)
        }
        imageButton7.setOnClickListener {
            reproducirTono(tonoGuinda)
        }
        imageButton8.setOnClickListener {
            reproducirTono(tonoLila)
        }
        imageButton9.setOnClickListener {
            reproducirTono(tonoMorado)
        }
        imageButton10.setOnClickListener {
            reproducirTono(tonoAnaranjado)
        }
        imageButton11.setOnClickListener {
            reproducirTono(tonoNegro)
        }
        imageButton12.setOnClickListener {
            reproducirTono(tonoRojo)
        }
        imageButton13.setOnClickListener {
            reproducirTono(tonoRosado)
        }
        imageButton14.setOnClickListener {
            reproducirTono(tonoVerde)
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


    private fun reproducirTono(tono: MediaPlayer) {
        // Verifica si el audio ya está reproduciendo y, si es así, detén la reproducción y reinicia
        if (tono.isPlaying) {
            tono.seekTo(0)
        } else {
            tono.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mAdView.destroy()
        // Libera los recursos de MediaPlayer cuando el fragmento se destruya para evitar pérdidas de memoria
        tonoAmarillo.release()
        tonoAzul.release()
        tonoBlanco.release()
        tonoCafe.release()
        tonoCeleste.release()
        tonoGris.release()
        tonoGuinda.release()
        tonoLila.release()
        tonoMorado.release()
        tonoAnaranjado.release()
        tonoNegro.release()
        tonoRojo.release()
        tonoRosado.release()
        tonoVerde.release()
    }
}