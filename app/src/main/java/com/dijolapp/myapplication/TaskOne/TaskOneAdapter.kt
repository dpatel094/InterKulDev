package com.dijolapp.myapplication.TaskOne

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.Address
import com.dijolapp.myapplication.TaskOne.Model.TaskOneModel

class TaskOneAdapter(
    private val tradeList: List<TaskOneModel>?,
    var taskOne: Task_One,
    var clickInterface: ClickInterface?
) :
    RecyclerView.Adapter<TaskOneAdapter.TaskViewHolder>() {
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
            } else {
                holder.ic_icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                holder.layout_hidden.visibility = View.VISIBLE
            }
        }
        holder.Rview_.layoutManager = LinearLayoutManager(taskOne)
        val taskOneAdapter = ListviewAdapter(tradeItem.address, taskOne)
        holder.Rview_.adapter = taskOneAdapter

    }

    override fun getItemCount(): Int {
        return tradeList!!.size
    }

    class TaskViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textSymbol: TextView = itemView.findViewById(R.id.textSymbol)
        val textPrice: TextView = itemView.findViewById(R.id.textPrice)
        val ic_icon: ImageView = itemView.findViewById(R.id.ic_icon)
        val layout_hidden: NestedScrollView = itemView.findViewById(R.id.layout_hidden)
        val Rview_: RecyclerView = itemView.findViewById(R.id.Rview_)

    }

    /*-------------------*/
  inner class ListviewAdapter(private val tradeList: ArrayList<Address>, var taskOne: Task_One) :
        RecyclerView.Adapter<ListviewAdapter.TaskViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            val itemView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.listview_checkbox, parent, false)
            return TaskViewHolder(itemView)
        }


        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            val tradeItem = tradeList[position]
            holder.txtName.text = tradeItem.street
            holder.checkBok.setOnCheckedChangeListener(null);
            holder.checkBok.isChecked = tradeItem.selected!!;


            holder.checkBok.setOnCheckedChangeListener { compoundButton, b ->
                if (compoundButton.isPressed) {
                    if (b) {
                        tradeItem.selected = b
                        clickInterface!!.onSelect(tradeItem)

                    } else {
                        tradeItem.selected = b
                       // clickInterface!!.onSelect(tradeItem)
                    }
                }
            }
        }

        override fun getItemCount(): Int {
            return tradeList!!.size
        }

        inner class TaskViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val txtName: TextView = itemView.findViewById(R.id.txtName)
            val checkBok: CheckBox = itemView.findViewById(R.id.checkBox)


        }

    }
}