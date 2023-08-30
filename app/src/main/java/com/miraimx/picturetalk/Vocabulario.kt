package com.miraimx.picturetalk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class Vocabulario : Fragment() {

    private lateinit var listaIzquierda: RecyclerView
    private lateinit var listaDerecha: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var todasLasPalabras: List<String>
    private lateinit var txtResultado: TextView

    private val palabras: List<Pair<String, String>> by lazy {
        obtenerPalabras()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vocabulario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheet = view.findViewById<LinearLayout>(R.id.bottomSheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        txtResultado = view.findViewById(R.id.txtResultado)

        searchView = view.findViewById<SearchView>(R.id.searchView)
        //val resultadoBusquedaTextView = view.findViewById<TextView>(R.id.resultadoBusqueda)

        // Configura el comportamiento del BottomSheet
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN // Inicialmente oculto
        bottomSheetBehavior.peekHeight = 66 // Altura visible del BottomSheet

        // Agrega un listener para detectar cambios de estado del BottomSheet
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // Aquí puedes realizar acciones en función del estado del BottomSheet
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // Aquí puedes realizar acciones en función del deslizamiento del BottomSheet
            }
        })

        listaIzquierda = view.findViewById(R.id.listaIzquierda)
        listaDerecha = view.findViewById(R.id.listaDerecha)

        todasLasPalabras = obtenerTodasLasPalabras()

        cargarPalabras(todasLasPalabras)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filtroPalabras = filtrarPalabras(newText)
                cargarPalabras(filtroPalabras)

                val palabraBuscada = newText?.trim() ?: ""
                val resultado = buscarPalabra(palabraBuscada)

                txtResultado.text = resultado
                return true
            }
        })
    }

    private fun cargarPalabras(palabras: List<String>) {
        val layoutManagerIzquierda = LinearLayoutManager(requireContext())
        val layoutManagerDerecha = LinearLayoutManager(requireContext())

        listaIzquierda.layoutManager = layoutManagerIzquierda
        listaDerecha.layoutManager = layoutManagerDerecha

        val adapterIzquierda = PalabraAdapter(obtenerPalabrasEspañol(palabras), requireContext())
        val adapterDerecha = PalabraAdapter(obtenerPalabrasIngles(palabras), requireContext())

        listaIzquierda.adapter = adapterIzquierda
        listaDerecha.adapter = adapterDerecha
    }

    private fun obtenerPalabrasEspañol(palabrasFiltradas: List<String>): List<String> {
        return palabrasFiltradas.map { palabra -> palabra.split("|")[0] }
    }

    private fun obtenerPalabrasIngles(palabrasFiltradas: List<String>): List<String> {
        return palabrasFiltradas.map { palabra -> palabra.split("|")[1] }
    }


    private fun obtenerTodasLasPalabras(): List<String> {
        return resources.getStringArray(R.array.lista_palabras).toList()
    }

    private fun obtenerPalabras(): List<Pair<String, String>> {
        val listaPalabras = resources.getStringArray(R.array.lista_palabras)
        return listaPalabras.map {
            it.split("|").let { palabras -> Pair(palabras[0], palabras[1]) }
        }
    }

    private fun filtrarPalabras(query: String?): List<String> {
        return todasLasPalabras.filter {
            it.contains(query ?: "", ignoreCase = true)
        }
    }

    private fun buscarPalabra(palabraBuscada: String): String {
        val palabrasEncontradas = palabras.filter {
            it.first.equals(palabraBuscada, ignoreCase = true) || it.second.equals(palabraBuscada, ignoreCase = true)
        }

        if (palabrasEncontradas.isNotEmpty()) {
            val resultadoBuilder = StringBuilder()
            palabrasEncontradas.forEachIndexed { index, (espanol, ingles) ->
                resultadoBuilder.append("Español: $espanol Inglés: $ingles")
                if (index < palabrasEncontradas.size - 1) {
                    resultadoBuilder.append("\n")
                }
            }
            return resultadoBuilder.toString()
        } else {
            return "Palabra no encontrada"
        }
    }

}