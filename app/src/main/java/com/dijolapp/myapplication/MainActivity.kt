package com.dijolapp.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dijolapp.myapplication.TaskOne.Task_One


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val task_1 :Button = findViewById(R.id.task_1)
        val task_2 :Button = findViewById(R.id.task_2)
        task_1.setOnClickListener {
            val intent = Intent(this, Task_One::class.java)
            startActivity(intent) }
        task_2.setOnClickListener {
            val intent = Intent(this, WebsocketActivity::class.java)
            startActivity(intent) }

    }
}