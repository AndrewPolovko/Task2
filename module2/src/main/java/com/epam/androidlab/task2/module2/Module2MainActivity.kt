package com.epam.androidlab.task2.module2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class Module2MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent().setClassName("com.epam.androidlab.task2.module1","com.epam.androidlab.task2.module1.Module1MainActivity"))
    }
}
