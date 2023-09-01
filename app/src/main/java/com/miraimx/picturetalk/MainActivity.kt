package com.miraimx.picturetalk

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.miraimx.picturetalk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdView : AdView

    private var backPressedTime: Long = 0
    private val backPressedInterval: Long = 2000
    // Intervalo de tiempo para considerar dos pulsaciones seguidas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_vocabulario,
                R.id.navigation_cuentos,
                R.id.navigation_aprender
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Agregar el callback para el botón "Back"
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Obtener el tiempo actual
                val currentTime = System.currentTimeMillis()

                if (currentTime - backPressedTime < backPressedInterval) {
                    // Si se pulsa dos veces dentro del intervalo, cerrar la aplicación
                    finishAffinity()
                } else {
                    // Si no, mostrar mensaje para volver a pulsar
                    backPressedTime = currentTime
                    Toast.makeText(this@MainActivity, "Presiona de nuevo para salir", Toast.LENGTH_SHORT).show()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
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
        mAdView.destroy()
        super.onDestroy()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_superior, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            /*R.id.configuracion -> {
                // Acción para la opción 1
                val intent = Intent(this, Configuracion::class.java)
                startActivity(intent)
                return true
            }*/
            R.id.acercaDe -> {
                // Acción para la opción 2
                val intent = Intent(this, AcercaDe::class.java)
                startActivity(intent)
                return true
            }
            /*R.id.cerrarSesion -> {
                // Acción para la opción 3
                // Mostrar el cuadro de diálogo de confirmación
                AlertDialog.Builder(this)
                    .setMessage("¿Seguro que quieres cerrar la sesión?")
                    .setPositiveButton("Salir") { dialog, which -> // Acción de confirmación
                        Firebase.auth.signOut()
                        Toast.makeText(this, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
                return true
            }*/
            else -> return super.onOptionsItemSelected(item)
        }
    }
}