package com.miraimx.picturetalk

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class Cuentos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cuentos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageButton1: ImageButton = view.findViewById(R.id.imgButton1)
        val imageButton2: ImageButton = view.findViewById(R.id.imgButton2)
        val imageButton3: ImageButton = view.findViewById(R.id.imgButton3)

        imageButton1.setOnClickListener {
            val idImagen = R.drawable.dibujotigrecachorro
            val idCancion = R.raw.azul
            val intent = Intent(context, AudioPlayerActivity::class.java)
            intent.putExtra("audioResourceId", idCancion)
            intent.putExtra("imageResourceId", idImagen)
            startActivity(intent)
        }

        imageButton2.setOnClickListener {
            val idImagen = R.drawable.dibujoconejo
            val idCancion = R.raw.amarillo
            val intent = Intent(context, AudioPlayerActivity::class.java)
            intent.putExtra("audioResourceId", idCancion)
            intent.putExtra("imageResourceId", idImagen)
            startActivity(intent)
        }

        imageButton3.setOnClickListener {
            val idImagen = R.drawable.dibujoespantagentes
            val idCancion = R.raw.verde
            val intent = Intent(context, AudioPlayerActivity::class.java)
            intent.putExtra("audioResourceId", idCancion)
            intent.putExtra("imageResourceId", idImagen)
            startActivity(intent)
        }
    }

}