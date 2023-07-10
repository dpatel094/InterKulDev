package com.dijolapp.myapplication.TaskOne

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.TaskOneModel

class ListviewAdapter(private val tradeList: List<TaskOneModel>?, var context: Context) :
    RecyclerView.Adapter<ListviewAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_trade, parent, false)
        return TaskViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tradeItem = tradeList?.get(position)
        holder.textSymbol.text = "Name : " + tradeItem!!.name
        holder.textPrice.text = "Email : " + tradeItem.email
        holder.ic_icon.visibility = View.VISIBLE
        holder.itemView.setOnClickListener {
            if (holder.layout_hidden.isVisible) {
                holder.layout_hidden.visibility = View.GONE
                holder.ic_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }else{
                holder.ic_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                holder.layout_hidden.visibility = View.VISIBLE
            }
        }
        var adapter = CustomAdapter(tradeItem!!.address, context)
        holder.listview_.adapter = adapter
    }

    override fun getItemCount(): Int {
        return tradeList!!.size
    }

    class TaskViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textSymbol: TextView = itemView.findViewById(R.id.textSymbol)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        val ic_icon: ImageView = itemView.findViewById(R.id.ic_icon)
        val layout_hidden: NestedScrollView = itemView.findViewById(R.id.layout_hidden)
        val listview_: ListView = itemView.findViewById(R.id.listview_)

    }

}