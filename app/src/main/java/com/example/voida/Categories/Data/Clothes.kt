package com.example.voida.Categories.Data

import com.example.voida.R


val terminalBoyFashion = SubCategory(isTerminal = true, terminalList = listOf("티셔츠", "맨투맨/후디", "셔츠", "니트/조끼", "아우터", "후드집업/집업", "바지", "정장/세트", "트레이닝복", "속옷/잠옷", "비치웨어", "테마의류", "커플/패밀리룩", "스포츠의류", "한복/수의", "신발", "가방/잡화"))
val terminalGirlsFashion = SubCategory(isTerminal = true, terminalList = listOf("티셔츠","맨투맨/후디","블라우스","니트/조끼","아우터","후드집업/집업","바지","스커트","원피스","정장/세트","트레이닝복","속옷/잠옷","비치웨어","테마의류","커플/패밀리룩","스포츠의류","임산부의류","한복/수의","신발","가방/잡화"))
val girlsFashion = SubCategory(
    name = "여성패션",
    child = listOf(terminalGirlsFashion)
)
val boysFashion = SubCategory(
    name = "남성패션",
    child = listOf(terminalBoyFashion)
)
val fashion = Category(
    icon = R.drawable.clothes,
    name = "패션의류/잡화",
    child = listOf(boysFashion, girlsFashion)
)





