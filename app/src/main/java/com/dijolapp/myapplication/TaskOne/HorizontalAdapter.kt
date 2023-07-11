package com.dijolapp.myapplication.TaskOne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.Address

class HorizontalAdapter(
    private val tradeList: ArrayList<Address>,
    var taskOne: Task_One,
   var  clickInterface: ClickInterface
) :
    RecyclerView.Adapter<HorizontalAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.listview_bottom, parent, false)
        return TaskViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tradeItem = tradeList[position]
        holder.txtName.text =  tradeItem.street
        holder.ic_icon.setOnClickListener {
            tradeItem.selected = false
            clickInterface.onSelect(tradeItem)
        }

    }

    override fun getItemCount(): Int {
        return tradeList!!.size
    }

    class TaskViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val ic_icon: ImageView = itemView.findViewById(R.id.ic_icon)


    }

}