package com.example.empowering_the_nation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SixWeekCourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_week_courses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val childBtn: Button = findViewById(R.id.childBtn)
        childBtn.setOnClickListener {
            val intent = Intent(this, ChildMindingInfo::class.java)
            startActivity(intent)

        }
        val cookingBtn: Button = findViewById(R.id.cookingBtn)
        cookingBtn.setOnClickListener {
            val intent = Intent(this, CookingInfo::class.java)
            startActivity(intent)
        }
        val gardenBtn: Button = findViewById(R.id.gardenBtn)
        gardenBtn.setOnClickListener {
            val intent = Intent(this, GardenInfo::class.java)
            startActivity(intent)
        }
        val sixMonthsBtn: Button = findViewById(R.id.sixMonthsBtn)
        sixMonthsBtn.setOnClickListener {
            val intent = Intent(this, SixMonthsCourses::class.java)
            startActivity(intent)
        }
        val contactfeesBtn: Button = findViewById(R.id.contactfeesBtn)
        contactfeesBtn.setOnClickListener {
            val intent = Intent(this, ContactFees::class.java)
            startActivity(intent)
        }
    }
}