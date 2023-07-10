package com.dijolapp.myapplication.TaskOne;


import com.dijolapp.myapplication.TaskOne.Model.Address;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public interface ClickInterface {
    void onSelect(Task_One taskOne);

    void onSelect( String street);

    void onSelect(@NotNull ArrayList<Address> tradeList);
}
