package com.dijolapp.myapplication.TaskOne

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.Address

//class ListviewAdapter(private val tradeList: ArrayList<Address>, var taskOne: Task_One) :
//    RecyclerView.Adapter<ListviewAdapter.TaskViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.listview_checkbox, parent, false)
//        return TaskViewHolder(itemView)
//    }
//
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        val tradeItem = tradeList[position]
//        holder.txtName.text =  tradeItem.street
//        holder.checkBok.isSelected = tradeItem.selected!!
//        holder.checkBok.setOnCheckedChangeListener { compoundButton, b ->
//            if (compoundButton.isPressed) {
//                if (b) {
//                    tradeItem.selected = b
//                    taskOne.ConvertJsonToList()
//                    notifyDataSetChanged()
//                } else {
//                    tradeItem.selected = b
//                    notifyDataSetChanged()
//                }
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return tradeList!!.size
//    }
//
//    class TaskViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
//        val txtName: TextView = itemView.findViewById(R.id.txtName)
//        val checkBok: CheckBox = itemView.findViewById(R.id.checkBox)
//
//
//    }
//
//}