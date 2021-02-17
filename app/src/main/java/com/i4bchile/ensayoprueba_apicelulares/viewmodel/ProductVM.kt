package com.i4bchile.ensayoprueba_apicelulares.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.ensayoprueba_apicelulares.model.data.Repository
import kotlinx.coroutines.launch

class ProductVM: ViewModel() {
    fun doSomething() {
        //esto es solo para probar el consumo de api. borrar después.
    }

    val repository= Repository()

    init{
        viewModelScope.launch{
            repository.getProductList()
        }
    }


}