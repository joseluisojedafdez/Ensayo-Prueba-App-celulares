package com.i4bchile.ensayoprueba_apicelulares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.i4bchile.ensayoprueba_apicelulares.databinding.ActivityMainBinding

/*
 *
 * [x] Control de versiones
 * [x] view binding
 *      [x] activar (build.gradle app)
 *      [x] actualizar Activities y fragments con viewBinding (Commit 1 "proyecto vacío con viewbinding activado")

 * [x] MainActivity
 *      [x] fragment container view
 * [] ViewModel (Commit 2 "activado Viewmodel y generado fragment container view"
 * [] consumo de API (1/listado 2/detalle)
 *      [] permiso de internet
 *      [] cleartext Traffic si es https
 *      [] dependencias retrofit
 *      [] pojos []listado [] detalle
 *      [] interfaz de operaciones
 *      [] cliente retrofit (Commit 3 "consumo de API activado y comprobado con logs") /(Commit 6 "se prueba el consumo de API para el detalle")
* [ ] ROOM (1/Listado 2/Detalle)
 *      [] Dependencias
 *      [] Type Converters
 *      [] interfaz de operaciones (DAO) [] listado []detalle
 *      [] pojos (entities) []listado [] detalle
 *      [] database & application (declarar application en Manifest) (Commit 4 "se activa room y se guardan los datos de la API en BBDD local")/(Commit 7 "Se 	guardan lo datos del detalle en base de datos local")*7 es opcional
 * [] Listado
 *      [] Fragmento de listado
 *      [] layout
 *      [] recycler view
 *      [] adapter
 *      [] Viewholder
 *      [] item layout
 *      [] enlazar las piezas (Commit 5 "se muestra el listado")
 *      [] onclick en un elemento de listado
 * [ ] detalle
 *      [] fragmento de detalle
 *      [] layout
 *      [] viewBinding
 *      [] observar la info del pokemon para detalle
 *      [] consumo de imágenes (Commit 8 "se muestra el detalle")
 *
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}