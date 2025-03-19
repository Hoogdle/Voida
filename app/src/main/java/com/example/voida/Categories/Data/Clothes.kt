package com.example.voida.Categories.Data

import com.example.voida.R

object Fashion{
    val icon: Int = R.drawable.clothes
    val name: String = "패션의류/잡화"
    val list = listOf(GirlsFashion, BoyFashion)
}

object GirlsFashion{
    val name: String = "여성패션"
    val list: List<String> = listOf("티셔츠","맨투맨/후디","블라우스","니트/조끼","아우터","후드집업/집업","바지","스커트","원피스","정장/세트","트레이닝복","속옷/잠옷","비치웨어","테마의류","커플/패밀리룩","스포츠의류","임산부의류","한복/수의","신발","가방/잡화")
}

object BoyFashion {
    val name: String = "남성패션"
    val list: List<String> = listOf(
        "티셔츠",
        "맨투맨/후디",
        "셔츠",
        "니트/조끼",
        "아우터",
        "후드집업/집업",
        "바지",
        "정장/세트",
        "트레이닝복",
        "속옷/잠옷",
        "비치웨어",
        "테마의류",
        "커플/패밀리룩",
        "스포츠의류",
        "한복/수의",
        "신발",
        "가방/잡화"
    )
}
