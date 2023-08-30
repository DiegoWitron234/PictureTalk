package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Animales : AppCompatActivity() {

    private lateinit var abeja: MediaPlayer
    private lateinit var acaro: MediaPlayer
    private lateinit var alacran: MediaPlayer
    private lateinit var arana: MediaPlayer
    private lateinit var ardilla: MediaPlayer
    private lateinit var armadillo: MediaPlayer
    private lateinit var caballo: MediaPlayer
    private lateinit var mariposa: MediaPlayer
    private lateinit var mosca: MediaPlayer
    private lateinit var perro: MediaPlayer
    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animales)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        abeja = MediaPlayer.create(this, R.raw.tono)
        acaro = MediaPlayer.create(this, R.raw.tono)
        alacran = MediaPlayer.create(this, R.raw.tono)
        arana = MediaPlayer.create(this, R.raw.tono)
        ardilla = MediaPlayer.create(this, R.raw.tono)
        armadillo = MediaPlayer.create(this, R.raw.tono)
        caballo = MediaPlayer.create(this, R.raw.tono)
        mariposa = MediaPlayer.create(this, R.raw.tono)
        mosca = MediaPlayer.create(this, R.raw.tono)
        perro = MediaPlayer.create(this, R.raw.tono)

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

        imageButton1.setOnClickListener {
            reproducirTono(abeja)
        }
        imageButton2.setOnClickListener {
            reproducirTono(acaro)
        }
        imageButton3.setOnClickListener {
            reproducirTono(alacran)
        }
        imageButton4.setOnClickListener {
            reproducirTono(arana)
        }
        imageButton5.setOnClickListener {
            reproducirTono(ardilla)
        }
        imageButton6.setOnClickListener {
            reproducirTono(armadillo)
        }
        imageButton7.setOnClickListener {
            reproducirTono(caballo)
        }
        imageButton8.setOnClickListener {
            reproducirTono(mariposa)
        }
        imageButton9.setOnClickListener {
            reproducirTono(mosca)
        }
        imageButton10.setOnClickListener {
            reproducirTono(perro)
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
        abeja.release()
        acaro.release()
        alacran.release()
        arana.release()
        ardilla.release()
        armadillo.release()
        caballo.release()
        mariposa.release()
        mosca.release()
        perro.release()
    }
}