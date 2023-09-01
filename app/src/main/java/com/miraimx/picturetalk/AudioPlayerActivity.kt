package com.miraimx.picturetalk

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity

class AudioPlayerActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var imagenCuento: ImageView
    private val handler = Handler()

    private var isPlaying = false
    private var audioResourceId = 0
    private var imageResourceId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_player)

        // Obtener el ID del recurso de audio enviado desde la actividad anterior
        audioResourceId = intent.getIntExtra("audioResourceId", 0)
        imageResourceId = intent.getIntExtra("imageResourceId", 0)

        imagenCuento = findViewById(R.id.imgCuento)

        imagenCuento.setImageResource(imageResourceId)

        mediaPlayer = MediaPlayer.create(this, audioResourceId)
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        seekBar = findViewById(R.id.seekBar)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer!!.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        val btnPlayPause = findViewById<Button>(R.id.btnPlayPause)

        btnPlayPause.setBackgroundColor(resources.getColor(R.color.verde))

        btnPlayPause.setOnClickListener {
            if (isPlaying) {
                pauseAudio()
            } else {
                playAudio()
            }
        }

        prepareMediaPlayer()
    }

    private fun prepareMediaPlayer() {
        seekBar.max = mediaPlayer!!.duration

        mediaPlayer!!.setOnCompletionListener {
            // Cuando la reproducción del audio termina, detenemos el audio
            pauseAudio()
        }
    }

    private fun playAudio() {
        mediaPlayer!!.start()
        isPlaying = true
        updateSeekBar()
        findViewById<Button>(R.id.btnPlayPause).text = "Pausa"
    }

    private fun pauseAudio() {
        mediaPlayer!!.pause()
        isPlaying = false
        findViewById<Button>(R.id.btnPlayPause).text = "Reproducir"
    }

    private fun updateSeekBar() {
        if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            seekBar.progress = mediaPlayer!!.currentPosition
            handler.postDelayed({ updateSeekBar() }, 1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer!!.isPlaying) {
            mediaPlayer?.stop()
        }

        mediaPlayer?.release()
        mediaPlayer = null
    }
}
