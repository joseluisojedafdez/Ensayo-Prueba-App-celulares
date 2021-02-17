package com.i4bchile.ensayoprueba_apicelulares.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.i4bchile.ensayoprueba_apicelulares.databinding.ItemListProductBinding
import com.i4bchile.ensayoprueba_apicelulares.model.Product

class ProductAdapter: RecyclerView.Adapter<ProductVH>() {

    private var productList=listOf<Product>()
    private val selected= MutableLiveData<Product>()
    fun getSelected(): LiveData<Product> {
        return selected
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
       val binding=ItemListProductBinding.inflate(LayoutInflater.from(parent.context))

        return ProductVH(binding)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val product=productList[position]
        holder.bind(product)
        holder.itemView.setOnClickListener{
            selected.value=product
        }
    }

    override fun getItemCount()=productList.size

    fun updateList(list: List<Product>) {
        productList=list
        notifyDataSetChanged()
    }


}

class ProductVH (val binding:ItemListProductBinding):RecyclerView.ViewHolder(binding.root) {


    fun bind(product: Product) {

        binding.tvNombreListado.text=product.name
        binding.tvPriceListado.text=product.price.toString()
        binding.imgListado.load(product.image)

    }


}
