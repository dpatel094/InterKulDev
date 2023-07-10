package com.dijolapp.myapplication.TaskOne.Model

import com.google.gson.annotations.SerializedName


data class Address (

  @SerializedName("street"  ) var street  : String? = null,
  @SerializedName("isSelected"   ) var selected   : Boolean? = false,


)