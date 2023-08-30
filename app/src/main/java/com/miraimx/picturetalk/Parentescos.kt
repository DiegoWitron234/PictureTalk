package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Parentescos : AppCompatActivity() {
    private lateinit var abuela: MediaPlayer
    private lateinit var abuelo: MediaPlayer
    private lateinit var madre: MediaPlayer
    private lateinit var padre: MediaPlayer
    private lateinit var ahijado: MediaPlayer
    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parentescos)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        abuela = MediaPlayer.create(this, R.raw.abuela)
        abuelo = MediaPlayer.create(this, R.raw.abuelo)
        madre = MediaPlayer.create(this, R.raw.madre)
        padre = MediaPlayer.create(this, R.raw.padre)
        ahijado = MediaPlayer.create(this, R.raw.ahijado)

        val imageButton1: ImageButton = findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = findViewById(R.id.imgButton3)
        val imageButton4: ImageButton = findViewById(R.id.imgButton4)
        val imageButton5: ImageButton = findViewById(R.id.imgButton5)

        imageButton1.setOnClickListener {
            reproducirTono(abuela)
        }
        imageButton2.setOnClickListener {
            reproducirTono(abuelo)
        }
        imageButton3.setOnClickListener {
            reproducirTono(madre)
        }
        imageButton4.setOnClickListener {
            reproducirTono(padre)
        }
        imageButton5.setOnClickListener {
            reproducirTono(ahijado)
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
        abuela.release()
        abuelo.release()
        madre.release()
        padre.release()
        ahijado.release()
    }
}