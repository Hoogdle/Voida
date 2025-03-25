package com.example.voida.ProductInfo

import com.example.voida.R

data class Review(
    val title: String,
    val contents: String
)

data class ProductInfoData(
    val image: Int,
    val eta: String,
    val score: String,
    val name: String,
    val price: Int,
    val productInfo: String,
    val reviewInfo: List<Review>
)

val review1 = Review(
    title = "아주 부드럽진 않지만 행사가로 먹어볼만해요\n",
    contents = "이런류의 초콜릿을 선물받아서 유명한 초콜릿만 \n" +
            "서너군데 먹어봤었어요. \n" +
            "그래서 이번엔 내가 사먹어보자 마침 가나초콜릿\n" +
            "행사가 있어서 겟했습니다. \n" +
            "수제브랜드를 따라오지는 못하는것 같습니다."
)

val review2 = Review(
    title = "제품 뚜껑이 그냥 열리는 제품",
    contents = "테이핑도 없고 그냥 열리네요. 그런데도 그 큰 보냉박스에 덩그러니.. 합포 제품은 비닐포장 되어있던데 너무 차이나는 제품 퀄리티\n"
)

val review3 = Review(
    title = "가나초콜렛을 그대로 생초콜렛이 된 느낌\n",
    contents = "맛이 가나초콜릿 사서먹는것과 별반 다르지 않았어요.\n"
)

val productInfo = ProductInfoData(
    image = R.drawable.product_info1,
    eta = "무료배송\n" +
            "내일(일) 3/16 새벽 7시 전 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "프리미엄 가나 생쇼콜라 밀크앤오트 (냉동)",
    price = 19000,
    productInfo = "디저트에 잘 어울리는 생쇼콜라 초콜릿입니다.\n" +
            "밀크 초콜릿이 함유되어 있으며, 향긋한 차 또는 커피에 곁들여 근사한 티타임을 가질 수 있습니다.\n" +
            "냉동 보관을 권장드립니다.",
    reviewInfo = listOf(review1, review2, review3)
)
