package com.example.login

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.login.data.RecyclerDetails
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var currentDate: TextView
    private lateinit var calender_button : ImageButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerDetails: ArrayList<RecyclerDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.background = null
        currentDate = findViewById<TextView>(R.id.currentDate)
        calender_button = findViewById(R.id.calender_button)
        calender_button.setOnClickListener{
            showDatePickerDialog()
        }
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val images = listOf(
            R.drawable.poster,
            R.drawable.poster,
            R.drawable.poster
        )
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = SliderAdapter(images)
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = AdapterClass(generateData()  )

    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedCalendar = Calendar.getInstance()
                selectedCalendar.set(selectedYear, selectedMonth, selectedDay)
                val dateFormat = SimpleDateFormat("EEEE, MMMM dd", Locale.getDefault())
                val selectedDate = dateFormat.format(selectedCalendar.time)
                currentDate.text = selectedDate
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun generateData(): ArrayList<RecyclerDetails>{
        val items = arrayListOf(
            RecyclerDetails(R.drawable.shop, R.drawable.shop, "249", "Credit Coded Customers"),
            RecyclerDetails(R.drawable.shop, R.drawable.shop, "142", "Retail Coded Customers"),
            RecyclerDetails(R.drawable.printer, R.drawable.shop, "32", "Retail Walking Customers"),
            RecyclerDetails(R.drawable.printer, R.drawable.shop, "32", "Retail 99999 Customers")
        )
        return items
    }



}
