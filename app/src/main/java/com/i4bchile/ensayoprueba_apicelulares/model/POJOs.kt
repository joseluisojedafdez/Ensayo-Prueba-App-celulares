package com.i4bchile.ensayoprueba_apicelulares.model

/*
"id": 1,
"name": "Samsung Galaxy A21s 64GB",
"price": 167253,
"image":
"https://images.samsung.com/is/image/samsung/es-galaxy-a21s-sm-a217fzkoe
ub-262755098?$PD_GALLERY_L_JPG$",
"description": "Tamaño 6,5''\n Densidad 294 ppi\nResolución de
pantalla 720 x 1600",
"lastPrice": 177253,
"credit": true

 */


data class Product (val id:Int,
                    val name:String,
                    val price:Int,
                    val image:String)

data class ProductDetail(val id:Int,
                         val name:String,
                         val price:Int,
                         val Image:String,
                         val description:String,
                         val lastPrice:Int,
                         val credit:Boolean)