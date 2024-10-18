package com.example.empowering_the_nation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SixMonthsCourses : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_months_courses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val sixweekBtn: Button = findViewById(R.id.sixweekBtn)
        sixweekBtn.setOnClickListener {
            val intent = Intent(this, SixWeekCourses::class.java)
            startActivity(intent)
        }
        val sewingBtn: Button = findViewById(R.id.sewingBtn)
        sewingBtn.setOnClickListener {
            val intent = Intent(this, SewinInfo::class.java)
            startActivity(intent)
        }
        val landBtn: Button = findViewById(R.id.landBtn)
        landBtn.setOnClickListener {
            val intent = Intent(this, LandScapingInfo::class.java)
            startActivity(intent)
        }
        val firstAidBtn: Button = findViewById(R.id.firstAidBtn)
        firstAidBtn.setOnClickListener {
            val intent = Intent(this, FirstAidInfo::class.java)
            startActivity(intent)
        }
        val lifeSkillsBtn: Button = findViewById(R.id.lifeSkillsBtn)
        lifeSkillsBtn.setOnClickListener {
            val intent = Intent(this, LifeSkillsInfo::class.java)
            startActivity(intent)
        }
        val contactfeesBtn: Button = findViewById(R.id.contactfeesBtn)
        contactfeesBtn.setOnClickListener {
            val intent = Intent(this, ContactFees::class.java)
            startActivity(intent)
        }
    }
}