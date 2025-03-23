package com.example.voida.Categories.Data

data class Category(
    val icon: Int,
    val name: String,
    val child: List<SubCategory>? = null
)

data class SubCategory(
    val name: String = "",
    val child: List<SubCategory>? = null,
    val parentTerminal: Boolean = false,
    val terminalList: List<String>? = null
)

