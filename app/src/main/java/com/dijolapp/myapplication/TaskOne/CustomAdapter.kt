package com.dijolapp.myapplication.TaskOne

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.Address

class CustomAdapter(private val dataSet: ArrayList<*>, mContext: Context) :
	ArrayAdapter<Any?>(mContext, R.layout.listview_checkbox, dataSet) {
	private class ViewHolder {
		lateinit var txtName: TextView
		lateinit var checkBox: CheckBox
	}
	
	override fun getCount(): Int {
		return dataSet.size
	}
	
	override fun getItem(position: Int): Address {
		return dataSet[position] as Address
	}
	
	override fun getView(
		position: Int,
		convertView: View?,
		parent: ViewGroup
	): View {
		var convertView = convertView
		val viewHolder: ViewHolder
		val result: View
		if (convertView == null) {
			viewHolder = ViewHolder()
			convertView =
				LayoutInflater.from(parent.context).inflate(R.layout.listview_checkbox, parent, false)
			viewHolder.txtName =
				convertView.findViewById(R.id.txtName)
			viewHolder.checkBox =
				convertView.findViewById(R.id.checkBox)
			result = convertView
			convertView.tag = viewHolder
		} else {
			viewHolder = convertView.tag as ViewHolder
			result = convertView
		}
		
		val item: Address = getItem(position)
		viewHolder.txtName.text = item.street
		viewHolder.checkBox.isChecked = item.selected!!
		return result
	}
}
