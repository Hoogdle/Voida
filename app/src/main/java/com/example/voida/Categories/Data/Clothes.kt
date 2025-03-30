package com.example.voida.Categories.Data

import com.example.voida.R


val terminalBoyFashion = listOf("티셔츠", "맨투맨/후디", "셔츠", "니트/조끼", "아우터", "후드집업/집업", "바지", "정장/세트", "트레이닝복", "속옷/잠옷", "비치웨어", "테마의류", "커플/패밀리룩", "스포츠의류", "한복/수의", "신발", "가방/잡화")
val terminalGirlsFashion  = listOf("티셔츠","맨투맨/후디","블라우스","니트/조끼","아우터","후드집업/집업","바지","스커트","원피스","정장/세트","트레이닝복","속옷/잠옷","비치웨어","테마의류","커플/패밀리룩","스포츠의류","임산부의류","한복/수의","신발","가방/잡화")

//val subboy1 = SubCategory(
//    name = "남성1",
//    parentTerminal = true,
//    terminalList = terminalBoyFashion
//)
//
//val subboy2 = SubCategory(
//    name = "남성2",
//    parentTerminal = true,
//    terminalList = terminalBoyFashion
//)

val girlsFashion = SubCategory(
    name = "여성패션",
    terminalList = terminalGirlsFashion,
    parentTerminal = true
)
val boysFashion = SubCategory(
    name = "남성패션",
    parentTerminal = true,
    terminalList = terminalBoyFashion
)
val fashion = Category(
    icon = R.drawable.clothes,
    name = "패션의류/잡화",
    child = listOf(boysFashion, girlsFashion)
)







