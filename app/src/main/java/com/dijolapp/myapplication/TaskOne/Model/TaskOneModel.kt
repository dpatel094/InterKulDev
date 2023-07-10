package com.dijolapp.myapplication.TaskOne.Model

import com.google.gson.annotations.SerializedName

data class TaskOneModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("address"  ) var address  : ArrayList<Address> = arrayListOf()
)