package com.i4bchile.ensayoprueba_apicelulares.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.ensayoprueba_apicelulares.model.Product
import com.i4bchile.ensayoprueba_apicelulares.model.ProductDetail
import com.i4bchile.ensayoprueba_apicelulares.model.data.Repository
import kotlinx.coroutines.launch

class ProductVM: ViewModel() {


    val repository= Repository()
    private val selected=MutableLiveData<Product>()

    fun getSelectedDetail(id:Int):LiveData<ProductDetail> {
        return repository.getDetail(id) }





    fun setSelected(product:Product){
        selected.value=product
    }


    fun loadSelectedDetail(id:Int){
        Log.d("ViewModel", "insertando producto con id: $id")
        viewModelScope.launch{
            selected.value?.let{
                repository.getProductDetail(id)}
        }
    }

    val productList=repository.productList

    init{
        viewModelScope.launch{
            repository.getProductList()
        }
    }


}