package com.i4bchile.ensayoprueba_apicelulares.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.i4bchile.ensayoprueba_apicelulares.databinding.FragmentDetailBinding
import com.i4bchile.ensayoprueba_apicelulares.model.ProductDetail
import com.i4bchile.ensayoprueba_apicelulares.viewmodel.ProductVM

class DetailFragment(val prodId:Int): Fragment() {

    private lateinit var binding:FragmentDetailBinding
    private val viewModel: ProductVM by activityViewModels()
    private var product=ProductDetail(0,"",0,"","",0,false)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentDetailBinding.inflate(inflater)
        binding.checkCredit.isClickable=false
        viewModel.loadSelectedDetail(prodId)
        viewModel.getSelectedDetail(prodId).observe(viewLifecycleOwner, {
            Log.d("Detail", "onCreateView: $it")
            it?.let{
                product=it
                binding.checkCredit.isChecked = it.credit
                binding.imgImagenDetalle.load(it.image)
                binding.tvNombreDetalle.text = it.name
                binding.tvPrecioDetalle.text = it.price.toString()
                binding.tvDescripcion.text=it.description
            }

        })

        binding.abSendEmail.setOnClickListener{

            val address=arrayOf("info@plaplix.cl")
            val subject="CONSULTA ${product.name} id ${product.id}"
            val text="“Hola\n" +
                    "Vi el producto ${product.name} y me gustaría que me contactaran a este correo o al\n" +
                    "siguiente número _________(indique número aquí)\n" +
                    "Quedo atento.”\n"

            composeEmail(address,subject,text)
        }


        return binding.root
    }

    fun composeEmail(address:Array<String>, subject: String, text:String) {
           val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, text)
        }

          startActivity(intent)

    }


}