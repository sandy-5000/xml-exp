package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mobile:EditText
    private lateinit var name:EditText
    private lateinit var address:EditText
    private lateinit var passwd:EditText
    private lateinit var rootLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById<ConstraintLayout>(R.id.main)
        mobile = findViewById(R.id.mobile)
        name = findViewById(R.id.name)
        address = findViewById(R.id.address)
        passwd = findViewById(R.id.passwd)
        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener {
            if(validateRules()){
                val intent = Intent(this, Confirm::class.java)
                intent.putExtra("mobile", mobile.text.toString())
                intent.putExtra("name", name.text.toString())
                intent.putExtra("address", address.text.toString())
                intent.putExtra("passwd", passwd.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }


    fun validateRules(): Boolean {
        var isValid = true

        if (mobile.text.isEmpty()) {
            mobile.error = "Mobile number should not be empty"
            Snackbar.make(rootLayout, "Mobile number should not be empty", Snackbar.LENGTH_SHORT).show()
            isValid = false
        } else if (mobile.text.length < 10) {
            mobile.error = "Mobile number should be 10 digits"
            Snackbar.make(rootLayout, "Mobile number should be 10 digits", Snackbar.LENGTH_SHORT).show()
            isValid = false
        }

        if (name.text.isEmpty()) {
            name.error = "Name should not be empty"

            Snackbar.make(rootLayout, "Name should not be empty", Snackbar.LENGTH_SHORT).show()
            isValid = false
        }

        if (address.text.isEmpty()) {
            address.error = "Address should not be empty"
            Snackbar.make(rootLayout, "Address should not be empty", Snackbar.LENGTH_SHORT).show()
            isValid = false
        }

        if (passwd.text.isEmpty()) {
            passwd.error = "Password should not be empty"
            Snackbar.make(rootLayout, "Password should not be empty", Snackbar.LENGTH_SHORT).show()
            isValid = false
        } else if (passwd.text.length < 8) {
            passwd.error = "Password should be greater than 8 characters"
            Snackbar.make(rootLayout, "Password should be greater than 8 characters", Snackbar.LENGTH_SHORT).show()
            isValid = false
        }

        return isValid
    }


}
