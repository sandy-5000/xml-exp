package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class Confirm : AppCompatActivity() {

    private lateinit var view1:TextView
    private lateinit var view2:TextView
    private lateinit var view3:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)
        val button = findViewById<Button>(R.id.confirmButton)
        button.setOnClickListener {
            val intent = Intent(this,Tabactivity::class.java)
            startActivity(intent)
        }
        Log.d("Intent shit", "onCreate: $intent.")

        view1.text = intent.getStringExtra("name")
        view2.text = intent.getStringExtra("mobile")
        view3.text = intent.getStringExtra("address")



    }
}
