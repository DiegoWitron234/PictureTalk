package com.miraimx.picturetalk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AcercaDe : AppCompatActivity() {

    private lateinit var txtAvisoPrivacidad: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        txtAvisoPrivacidad = findViewById(R.id.txtAvisoPrivacidad)

        txtAvisoPrivacidad.setOnClickListener {
            openHyperlink("https://drive.google.com/file/d/1gvOjSH_-BYWvEoIGlE6eS6BLOy_tmnY8/view")
        }
    }

    private fun openHyperlink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}