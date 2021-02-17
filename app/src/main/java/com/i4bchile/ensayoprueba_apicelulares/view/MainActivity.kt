package com.i4bchile.ensayoprueba_apicelulares.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.i4bchile.ensayoprueba_apicelulares.R
import com.i4bchile.ensayoprueba_apicelulares.databinding.ActivityMainBinding
import com.i4bchile.ensayoprueba_apicelulares.viewmodel.ProductVM

/*
 *
 * [x] Control de versiones
 * [x] view binding
 *      [x] activar (build.gradle app)
 *      [x] actualizar Activities y fragments con viewBinding (Commit 1 "proyecto vacío con viewbinding activado")

 * [x] MainActivity
 *      [x] fragment container view
 * [x] ViewModel (Commit 2 "activado Viewmodel y generado fragment container view"
 * [x] consumo de API (1/listado 2/detalle)
 *      [x] permiso de internet
 *      [x] cleartext Traffic si es https
 *      [x] dependencias retrofit
 *      [x] pojos [x]listado [x] detalle
 *      [x] interfaz de operaciones
 *      [x] cliente retrofit (Commit 3 "consumo de API activado y comprobado con logs") /(Commit 6 "se prueba el consumo de API para el detalle")
* [x ] ROOM (1/Listado 2/Detalle)
 *      [x] Dependencias
 *      [] Type Converters (n/a)
 *      [x] interfaz de operaciones (DAO) [x] listado []detalle
 *      [x] pojos (entities) [x]listado [x] detalle
 *      [x] database & application (declarar application en Manifest) (Commit 4 "se activa room y se guardan los datos de la API en BBDD local")/(Commit 7 "Se 	guardan lo datos del detalle en base de datos local")*7 es opcional
 * [x] Listado
 *      [x] Fragmento de listado
 *      [x] layout
 *      [x] recycler view
 *      [x] adapter
 *      [x] Viewholder
 *      [x] item layout
 *      [x] enlazar las piezas (Commit 5 "se muestra el listado")
 *      [x] onclick en un elemento de listado
 * [x ] detalle
 *      [x] fragmento de detalle
 *      [x] layout
 *      [x] viewBinding
 *      [x] observar la info del producto para detalle
 *      [x] consumo de imágenes (Commit 8 "se muestra el detalle")
 *      [ ] boton para enviar el email
 *
 * [] testing
 *      [] 1 test unitario
 *      [] 1 test instrumental
 *
 */

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)

       supportFragmentManager
           .beginTransaction()
           .replace(R.id.main_container,ListFragment())
           .addToBackStack("volver")
           .commit()


        setContentView(binding.root)
    }
}