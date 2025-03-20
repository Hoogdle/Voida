package com.example.voida.Categories.Data

class Category(
    icon: Int,
    name: String,
    child: List<SubCategory>
){
    init{
        val icon: Int = icon
        val name: String = name
        val child: List<SubCategory> = child
    }
}

class SubCategory(
    name: String,
    child: List<SubCategory>
){
    init {
        val name: String = name
        val child: List<SubCategory> = child
    }
}