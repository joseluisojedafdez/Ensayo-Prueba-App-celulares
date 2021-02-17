package com.i4bchile.ensayoprueba_apicelulares.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.i4bchile.ensayoprueba_apicelulares.databinding.FragmentDetailBinding
import com.i4bchile.ensayoprueba_apicelulares.viewmodel.ProductVM

class DetailFragment(val prodId:Int): Fragment() {

    private lateinit var binding:FragmentDetailBinding
    private val viewModel: ProductVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentDetailBinding.inflate(inflater)
        binding.checkCredit.isClickable=false

        viewModel.getSelectedDetail(prodId).observe(viewLifecycleOwner, {
            Log.d("Detail", "onCreateView: $it")
            binding.checkCredit.isChecked = it.credit
            binding.imgImagenDetalle.load(it.image)
            binding.tvNombreDetalle.text = it.name
            binding.tvPrecioDetalle.text = it.price.toString()

        })


        return binding.root
    }



}