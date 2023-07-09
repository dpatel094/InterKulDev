package com.dijolapp.myapplication

import org.json.JSONException
import org.json.JSONObject

class WebsocketItem {
    var symbol: String? = null
    var tradeId: Long = 0
    var price = 0.0
    var quantity = 0.0
    var buyerOrderId: Long = 0
    var sellerOrderId: Long = 0
    var tradeTime: Long = 0
    var isBuyerMaker = false
    var isBestMatch = false

    companion object {

        @Throws(JSONException::class)
        fun fromJson(jsonObject: JSONObject): WebsocketItem {
            val websocketItem = WebsocketItem()
            websocketItem.symbol = (jsonObject.getString("s"))
            websocketItem.tradeId = (jsonObject.getLong("t"))
            websocketItem.price = (jsonObject.getDouble("p"))
            websocketItem.quantity = (jsonObject.getDouble("q"))
            websocketItem.buyerOrderId = (jsonObject.getLong("b"))
            websocketItem.sellerOrderId = (jsonObject.getLong("a"))
            websocketItem.tradeTime = (jsonObject.getLong("T"))
            websocketItem.isBuyerMaker = (jsonObject.getBoolean("m"))
            websocketItem.isBestMatch = (jsonObject.getBoolean("M"))
            return websocketItem
        }
    }
}