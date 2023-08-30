package com.miraimx.picturetalk

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdView

class Alimentos : AppCompatActivity() {
    private lateinit var aguacate: MediaPlayer
    private lateinit var ajo: MediaPlayer
    private lateinit var banana: MediaPlayer
    private lateinit var calabaza: MediaPlayer
    private lateinit var cebolla: MediaPlayer
    private lateinit var champinon: MediaPlayer
    private lateinit var chayote: MediaPlayer
    private lateinit var chicozapote: MediaPlayer
    private lateinit var chile: MediaPlayer
    private lateinit var chirimoya: MediaPlayer
    private lateinit var durazno: MediaPlayer
    private lateinit var frijol: MediaPlayer
    private lateinit var guayaba: MediaPlayer
    private lateinit var guineo: MediaPlayer
    private lateinit var hiervasanta: MediaPlayer
    private lateinit var lechuga: MediaPlayer
    private lateinit var limon: MediaPlayer
    private lateinit var maiz: MediaPlayer
    private lateinit var mandarina: MediaPlayer
    private lateinit var manzana: MediaPlayer
    private lateinit var milpa: MediaPlayer
    private lateinit var mora: MediaPlayer
    private lateinit var nopal: MediaPlayer
    private lateinit var papa: MediaPlayer
    private lateinit var papaya: MediaPlayer
    private lateinit var pinia: MediaPlayer
    private lateinit var tomate: MediaPlayer

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alimentos)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        aguacate = MediaPlayer.create(this, R.raw.tono)
        ajo = MediaPlayer.create(this, R.raw.tono)
        banana = MediaPlayer.create(this, R.raw.tono)
        calabaza = MediaPlayer.create(this, R.raw.tono)
        cebolla = MediaPlayer.create(this, R.raw.tono)
        champinon = MediaPlayer.create(this, R.raw.tono)
        chayote = MediaPlayer.create(this, R.raw.tono)
        chicozapote = MediaPlayer.create(this, R.raw.tono)
        chile = MediaPlayer.create(this, R.raw.tono)
        chirimoya = MediaPlayer.create(this, R.raw.tono)
        durazno = MediaPlayer.create(this, R.raw.tono)
        frijol = MediaPlayer.create(this, R.raw.tono)
        guayaba = MediaPlayer.create(this, R.raw.tono)
        guineo = MediaPlayer.create(this, R.raw.tono)
        hiervasanta = MediaPlayer.create(this, R.raw.tono)
        lechuga = MediaPlayer.create(this, R.raw.tono)
        limon = MediaPlayer.create(this, R.raw.tono)
        maiz = MediaPlayer.create(this, R.raw.tono)
        mandarina = MediaPlayer.create(this, R.raw.tono)
        manzana = MediaPlayer.create(this, R.raw.tono)
        milpa = MediaPlayer.create(this, R.raw.tono)
        mora = MediaPlayer.create(this, R.raw.tono)
        nopal = MediaPlayer.create(this, R.raw.tono)
        papa = MediaPlayer.create(this, R.raw.tono)
        papaya = MediaPlayer.create(this, R.raw.tono)
        pinia = MediaPlayer.create(this, R.raw.tono)
        tomate = MediaPlayer.create(this, R.raw.tono)

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
        val imageButton15: ImageButton = findViewById(R.id.imgButton15)
        val imageButton16: ImageButton = findViewById(R.id.imgButton16)
        val imageButton17: ImageButton = findViewById(R.id.imgButton17)
        val imageButton18: ImageButton = findViewById(R.id.imgButton18)
        val imageButton19: ImageButton = findViewById(R.id.imgButton19)
        val imageButton20: ImageButton = findViewById(R.id.imgButton20)
        val imageButton21: ImageButton = findViewById(R.id.imgButton21)
        val imageButton22: ImageButton = findViewById(R.id.imgButton22)
        val imageButton23: ImageButton = findViewById(R.id.imgButton23)
        val imageButton24: ImageButton = findViewById(R.id.imgButton24)
        val imageButton25: ImageButton = findViewById(R.id.imgButton25)
        val imageButton26: ImageButton = findViewById(R.id.imgButton26)
        val imageButton27: ImageButton = findViewById(R.id.imgButton27)

        imageButton1.setOnClickListener {
            reproducirTono(aguacate)
        }
        imageButton2.setOnClickListener {
            reproducirTono(ajo)
        }
        imageButton3.setOnClickListener {
            reproducirTono(banana)
        }
        imageButton4.setOnClickListener {
            reproducirTono(calabaza)
        }
        imageButton5.setOnClickListener {
            reproducirTono(cebolla)
        }
        imageButton6.setOnClickListener {
            reproducirTono(champinon)
        }
        imageButton7.setOnClickListener {
            reproducirTono(chayote)
        }
        imageButton8.setOnClickListener {
            reproducirTono(chicozapote)
        }
        imageButton9.setOnClickListener {
            reproducirTono(chile)
        }
        imageButton10.setOnClickListener {
            reproducirTono(chirimoya)
        }
        imageButton11.setOnClickListener {
            reproducirTono(durazno)
        }
        imageButton12.setOnClickListener {
            reproducirTono(frijol)
        }
        imageButton13.setOnClickListener {
            reproducirTono(guayaba)
        }
        imageButton14.setOnClickListener {
            reproducirTono(guineo)
        }
        imageButton15.setOnClickListener {
            reproducirTono(hiervasanta)
        }
        imageButton16.setOnClickListener {
            reproducirTono(lechuga)
        }
        imageButton17.setOnClickListener {
            reproducirTono(limon)
        }
        imageButton18.setOnClickListener {
            reproducirTono(maiz)
        }
        imageButton19.setOnClickListener {
            reproducirTono(mandarina)
        }
        imageButton20.setOnClickListener {
            reproducirTono(manzana)
        }
        imageButton21.setOnClickListener {
            reproducirTono(milpa)
        }
        imageButton22.setOnClickListener {
            reproducirTono(mora)
        }
        imageButton23.setOnClickListener {
            reproducirTono(nopal)
        }
        imageButton24.setOnClickListener {
            reproducirTono(papa)
        }
        imageButton25.setOnClickListener {
            reproducirTono(papaya)
        }
        imageButton26.setOnClickListener {
            reproducirTono(pinia)
        }
        imageButton27.setOnClickListener {
            reproducirTono(tomate)
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
        aguacate.release()
        ajo.release()
        banana.release()
        calabaza.release()
        cebolla.release()
        champinon.release()
        chayote.release()
        chicozapote.release()
        chile.release()
        chirimoya.release()
        durazno.release()
        frijol.release()
        guayaba.release()
        guineo.release()
        hiervasanta.release()
        lechuga.release()
        limon.release()
        maiz.release()
        mandarina.release()
        manzana.release()
        milpa.release()
        mora.release()
        nopal.release()
        papa.release()
        papaya.release()
        pinia.release()
        tomate.release()
    }
}