package com.dijolapp.myapplication.TaskOne

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijolapp.myapplication.R
import com.dijolapp.myapplication.TaskOne.Model.Address
import com.dijolapp.myapplication.TaskOne.Model.TaskOneModel
import com.dijolapp.myapplication.Utils
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonParser

class Task_One : AppCompatActivity() {
    var rv_list : RecyclerView? = null
    var rv_bottom : RecyclerView? = null
    var taskOneModel: List<TaskOneModel>? = null
    var taskOneAdapter: TaskOneAdapter? = null
    var horizontalAdapter: HorizontalAdapter? = null
    var clickInterface : ClickInterface? = null
    var addressList: ArrayList<Address>? =  ArrayList()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_one)
        rv_list = findViewById(R.id.rv_list)
        rv_bottom = findViewById(R.id.rv_bottom)


        rv_list!!.layoutManager = LinearLayoutManager(this)
        rv_bottom!!.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        taskOneModel = ArrayList()
        clickInterface = object : ClickInterface {


            override fun onSelectBottom(tradeLis: Address,position :Int) {
                if (addressList!!.size > 0){
                    addressList!!.removeAt(position)
                }
                taskOneAdapter!!.notifyDataSetChanged()
                horizontalAdapter!!.notifyDataSetChanged()
            }

            override fun onSelect(tradeLis: Address) {


                if (tradeLis.selected!!){
                    addressList!!.addAll(listOf(tradeLis))
                }else{
                    addressList!!.removeAll(listOf(tradeLis).toSet())
                }


                horizontalAdapter!!.notifyDataSetChanged()
                taskOneAdapter!!.notifyDataSetChanged()
            }
        }

        horizontalAdapter = HorizontalAdapter(addressList!!,this@Task_One,clickInterface!!)
        rv_bottom!!.adapter = horizontalAdapter
        ConvertJsonToList()

    }

    fun ConvertJsonToList(){
        val jsonObjectt: JsonArray = JsonParser.parseString(Utils.getJson).asJsonArray
        val gson = GsonBuilder().create()
         taskOneModel = gson.fromJson(jsonObjectt,Array<TaskOneModel>::class.java).toList()
        Log.i("gson",jsonObjectt.toString())
        taskOneAdapter = TaskOneAdapter(taskOneModel,this@Task_One,clickInterface)

        rv_list!!.adapter = taskOneAdapter


    }
}