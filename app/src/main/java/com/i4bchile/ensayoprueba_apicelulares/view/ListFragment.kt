package com.i4bchile.ensayoprueba_apicelulares.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.i4bchile.ensayoprueba_apicelulares.R
import com.i4bchile.ensayoprueba_apicelulares.databinding.FragmentListBinding
import com.i4bchile.ensayoprueba_apicelulares.viewmodel.ProductVM

class ListFragment: Fragment() {

    private val viewModel: ProductVM by activityViewModels()
    private lateinit var binding:FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentListBinding.inflate(inflater)
        val adapter=ProductAdapter()
        binding.rvLista.adapter=adapter
        binding.rvLista.layoutManager=GridLayoutManager(this.context,1)
        viewModel.productList.observe(viewLifecycleOwner,{
                productList->productList?.let{
                adapter.updateList(it)}
        })

        adapter.getSelected().observe(viewLifecycleOwner,{ product->product?.let{
            viewModel.setSelected(it)}

            activity
                ?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container,DetailFragment(product.id))
                ?.addToBackStack("volver")
                ?.commit()
        })
        return binding.root
    }



}