package com.dijolapp.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.WebsocketAdapter.TradeViewHolder

class WebsocketAdapter(private val tradeList: List<WebsocketItem>?) :
    RecyclerView.Adapter<TradeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_trade, parent, false)
        return TradeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TradeViewHolder, position: Int) {
       // val tradeItem = tradeList?.get(position)
        val tradeItem = tradeList?.get(position)
        holder.textSymbol.text = "Symbol : "+tradeItem!!.symbol
        holder.textPrice.text = "Price : "+tradeItem.price.toString()

    }

    override fun getItemCount(): Int {
        return tradeList!!.size
    }
    class TradeViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textSymbol: TextView = itemView.findViewById(R.id.textSymbol)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
    }

}