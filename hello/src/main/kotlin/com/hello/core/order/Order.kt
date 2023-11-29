package com.hello.core.order

class Order (
    private val memberId: Long,
    private val itemName: String,
    private val itemPrice: Int,
    val discountPrice: Int
) {
    fun calculatePrice(): Int = itemPrice - discountPrice
    override fun toString(): String {
        return "Order(memberId=$memberId, itemName='$itemName', itemPrice=$itemPrice, discountPrice=$discountPrice)"
    }

}