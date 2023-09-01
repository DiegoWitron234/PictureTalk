package com.miraimx.picturetalk


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class Aprender : Fragment() {

    private lateinit var btnColores: LinearLayout
    private lateinit var btnAlimentos: LinearLayout
    private lateinit var btnAnimales: LinearLayout
    private lateinit var btnNumeros: LinearLayout
    private lateinit var btnCuerpo: LinearLayout
    private lateinit var btnParentezcos: LinearLayout
    //private lateinit var btnTiempo: LinearLayout
    //private lateinit var btnVerbos: LinearLayout
    //private lateinit var btnSaludos: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aprender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnColores = view.findViewById(R.id.btnColores)
        btnAlimentos = view.findViewById(R.id.btnAlimentos)
        btnAnimales = view.findViewById(R.id.btnAnimales)
        btnNumeros = view.findViewById(R.id.btnNumeros)
        btnCuerpo = view.findViewById(R.id.btnCuerpo)
        btnParentezcos = view.findViewById(R.id.btnParentezcos)
        //btnTiempo = view.findViewById(R.id.btnTiempo)
        //btnVerbos = view.findViewById(R.id.btnVerbos)
        //btnSaludos = view.findViewById(R.id.btnSaludos)

        btnColores.setOnClickListener {
            val intent = Intent(requireContext(), ListaColores::class.java)
            startActivity(intent)
        }
        btnAlimentos.setOnClickListener {
            val intent = Intent(requireContext(), Alimentos::class.java)
            startActivity(intent)
        }
        btnAnimales.setOnClickListener {
            val intent = Intent(requireContext(), Animales::class.java)
            startActivity(intent)
        }
        btnNumeros.setOnClickListener {
            val intent = Intent(requireContext(), Numeros::class.java)
            startActivity(intent)
        }
        btnCuerpo.setOnClickListener {
            val intent = Intent(requireContext(), Cuerpo::class.java)
            startActivity(intent)
        }
        btnParentezcos.setOnClickListener {
            val intent = Intent(requireContext(), Parentescos::class.java)
            startActivity(intent)
        }
        /*
        btnTiempo.setOnClickListener {
            val intent = Intent(requireContext(), Tiempo::class.java)
            startActivity(intent)
        }
        btnVerbos.setOnClickListener {
            val intent = Intent(requireContext(), Verbos::class.java)
            startActivity(intent)
        }
        btnSaludos.setOnClickListener {
            val intent = Intent(requireContext(), Saludos::class.java)
            startActivity(intent)
        }
         */
    }
}

