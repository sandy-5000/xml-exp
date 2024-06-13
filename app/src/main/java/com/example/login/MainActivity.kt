package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodek
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        val mobile = findViewById<EditText>(R.id.mobile)
        val name = findViewById<EditText>(R.id.name)
        val address = findViewById<EditText>(R.id.address)
        val passwd = findViewById<EditText>(R.id.passwd)
        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            val intent = Intent(this, Confirm::class.java)
            startActivity(intent)
        }
        mobile.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val inputText = s.toString()
                viewmodel.mobile = inputText
            }

            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                if(inputText.length < 10){
                    Toast.makeText(this@MainActivity, "Enter mobile number correctly",Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}
