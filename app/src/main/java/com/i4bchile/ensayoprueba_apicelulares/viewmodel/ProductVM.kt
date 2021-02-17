package com.i4bchile.ensayoprueba_apicelulares.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.ensayoprueba_apicelulares.model.data.Repository
import kotlinx.coroutines.launch

class ProductVM: ViewModel() {


    val repository= Repository()

    val productList=repository.productList

    init{
        viewModelScope.launch{
            repository.getProductList()
        }
    }


}