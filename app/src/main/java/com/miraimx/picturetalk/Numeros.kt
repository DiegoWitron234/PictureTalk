package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class Numeros : AppCompatActivity() {
    private lateinit var uno: MediaPlayer
    private lateinit var dos: MediaPlayer
    private lateinit var tres: MediaPlayer
    private lateinit var cuatro: MediaPlayer
    private lateinit var cinco: MediaPlayer
    private lateinit var seis: MediaPlayer
    private lateinit var siete: MediaPlayer
    private lateinit var ocho: MediaPlayer
    private lateinit var nueve: MediaPlayer
    private lateinit var diez: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numeros)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        uno = MediaPlayer.create(this, R.raw.tono)
        dos = MediaPlayer.create(this, R.raw.tono)
        tres = MediaPlayer.create(this, R.raw.tono)
        cuatro = MediaPlayer.create(this, R.raw.tono)
        cinco = MediaPlayer.create(this, R.raw.tono)
        seis = MediaPlayer.create(this, R.raw.tono)
        siete = MediaPlayer.create(this, R.raw.tono)
        ocho = MediaPlayer.create(this, R.raw.tono)
        nueve = MediaPlayer.create(this, R.raw.tono)
        diez = MediaPlayer.create(this, R.raw.tono)

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
            reproducirTono(uno)
        }
        imageButton2.setOnClickListener {
            reproducirTono(dos)
        }
        imageButton3.setOnClickListener {
            reproducirTono(tres)
        }
        imageButton4.setOnClickListener {
            reproducirTono(cuatro)
        }
        imageButton5.setOnClickListener {
            reproducirTono(cinco)
        }
        imageButton6.setOnClickListener {
            reproducirTono(seis)
        }
        imageButton7.setOnClickListener {
            reproducirTono(siete)
        }
        imageButton8.setOnClickListener {
            reproducirTono(ocho)
        }
        imageButton9.setOnClickListener {
            reproducirTono(nueve)
        }
        imageButton10.setOnClickListener {
            reproducirTono(diez)
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
        uno.release()
        dos.release()
        tres.release()
        cuatro.release()
        cinco.release()
        seis.release()
        siete.release()
        ocho.release()
        nueve.release()
        diez.release()
    }
}