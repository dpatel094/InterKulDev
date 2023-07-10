package com.dijolapp.myapplication.TaskOne;


import com.dijolapp.myapplication.TaskOne.Model.Address;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface ClickInterface {

    void onSelectBottom(Address address,Integer position);

    void onSelect(Address address);
}
