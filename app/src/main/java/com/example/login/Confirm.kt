package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class Confirm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
//        val viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        val v:MainViewModel by sharedView
        val a = findViewById<LinearLayout>(R.id.details)
        val mobile = a.findViewById<TextView>(R.id.view1)
        mobile.text = viewmodel.mobile


    }
}
