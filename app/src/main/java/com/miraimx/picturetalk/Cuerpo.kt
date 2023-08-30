package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Cuerpo : AppCompatActivity() {

    private lateinit var abdomen: MediaPlayer
    private lateinit var boca: MediaPlayer
    private lateinit var brazo: MediaPlayer
    private lateinit var cuello: MediaPlayer
    private lateinit var garganta: MediaPlayer
    private lateinit var mano: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuerpo)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        abdomen = MediaPlayer.create(this, R.raw.abdomen)
        boca = MediaPlayer.create(this, R.raw.boca)
        brazo = MediaPlayer.create(this, R.raw.brazo)
        cuello = MediaPlayer.create(this, R.raw.cuello)
        garganta = MediaPlayer.create(this, R.raw.garganta)
        mano = MediaPlayer.create(this, R.raw.mano)

        val imageButton1: ImageButton = findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = findViewById(R.id.imgButton3)
        val imageButton4: ImageButton = findViewById(R.id.imgButton4)
        val imageButton5: ImageButton = findViewById(R.id.imgButton5)
        val imageButton6: ImageButton = findViewById(R.id.imgButton6)

        imageButton1.setOnClickListener {
            reproducirTono(abdomen)
        }
        imageButton2.setOnClickListener {
            reproducirTono(boca)
        }
        imageButton3.setOnClickListener {
            reproducirTono(brazo)
        }
        imageButton4.setOnClickListener {
            reproducirTono(cuello)
        }
        imageButton5.setOnClickListener {
            reproducirTono(garganta)
        }
        imageButton6.setOnClickListener {
            reproducirTono(mano)
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
        // Verifica si el audio ya está reproduciendo y, si es así, detiene la reproducción y la reinicia
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
        abdomen.release()
        boca.release()
        brazo.release()
        cuello.release()
        garganta.release()
        mano.release()
    }
}