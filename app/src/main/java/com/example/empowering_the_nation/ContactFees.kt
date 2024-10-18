package com.example.empowering_the_nation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactFees : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_fees)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize CheckBoxes and set onClickListener
        val sewingCheck: CheckBox = findViewById(R.id.sewingcheck)
        sewingCheck.setOnClickListener { onCheckBoxClicked(sewingCheck) }

        val firstCheck: CheckBox = findViewById(R.id.firstcheck)
        firstCheck.setOnClickListener { onCheckBoxClicked(firstCheck) }

        val childCheck: CheckBox = findViewById(R.id.childcheck)
        childCheck.setOnClickListener { onCheckBoxClicked(childCheck) }

        val landCheck: CheckBox = findViewById(R.id.landcheck)
        landCheck.setOnClickListener { onCheckBoxClicked(landCheck) }

        val gardenCheck: CheckBox = findViewById(R.id.gardencheck)
        gardenCheck.setOnClickListener { onCheckBoxClicked(gardenCheck) }

        val cookingCheck: CheckBox = findViewById(R.id.cookingcheck)
        cookingCheck.setOnClickListener { onCheckBoxClicked(cookingCheck) }

        val lifeCheck: CheckBox = findViewById(R.id.lifecheck)
        lifeCheck.setOnClickListener { onCheckBoxClicked(lifeCheck) }

        val doneBtn: Button = findViewById(R.id.doneBtn)
        doneBtn.setOnClickListener {
            val intent = Intent(this, FinalPage::class.java)
            startActivity(intent)
        }

        // Calculate Fees process
        val calculateFeesButton: Button = findViewById(R.id.calculateFees)
        val totalFeesTextView: TextView = findViewById(R.id.totalFees)
        val preTotalTextView: TextView = findViewById(R.id.preTotal)
        val vatTextView: TextView = findViewById(R.id.vat)
        val discountTextView: TextView = findViewById(R.id.discount)

        // Set onClickListener for calculate fees button
        calculateFeesButton.setOnClickListener {
            // Calculate the total fees depending on the CheckBox clicked
            calculateFees(firstCheck.isChecked, sewingCheck.isChecked, childCheck.isChecked,
                cookingCheck.isChecked, gardenCheck.isChecked, landCheck.isChecked,
                totalFeesTextView, preTotalTextView, vatTextView, discountTextView)
        }
    }

    private fun onCheckBoxClicked(view: CheckBox) {
        // Determine if the checkbox is checked
        val checked = view.isChecked

        // Which checkbox is clicked using when
        when (view.id) {
            R.id.sewingcheck -> {
                if (checked)
                    Toast.makeText(this, "Sewing Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Sewing Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.firstcheck -> {
                if (checked)
                    Toast.makeText(this, "First Aid Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "First Aid Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.childcheck -> {
                if (checked)
                    Toast.makeText(this, "Child Minding Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Child Minding Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.landcheck -> {
                if (checked)
                    Toast.makeText(this, "Landscaping Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Landscaping Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.gardencheck -> {
                if (checked)
                    Toast.makeText(this, "Garden Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Garden Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.cookingcheck -> {
                if (checked)
                    Toast.makeText(this, "Cooking Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Cooking Course not added", Toast.LENGTH_SHORT).show()
            }
            R.id.lifecheck -> {
                if (checked)
                    Toast.makeText(this, "Life Skills Course added", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Life Skills Course not added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateFees(firstAid: Boolean, sewing: Boolean, childMinding: Boolean,
                              cooking: Boolean, gardenMaintenance: Boolean, landscaping: Boolean,
                              totalFees: TextView, preTotal: TextView, vat: TextView, discount: TextView) {
        var preTotalAmount = 0

        // Calculate pre-total based on selected courses
        if (firstAid) preTotalAmount += 1500
        if (sewing) preTotalAmount += 1500
        if (childMinding) preTotalAmount += 750
        if (cooking) preTotalAmount += 750
        if (gardenMaintenance) preTotalAmount += 750
        if (landscaping) preTotalAmount += 1500

        // Display pre-total
        preTotal.text = "Pre-Total: R$preTotalAmount"

        // Calculating any discounts applied (5% for 2 courses, 10% for 3, 15% for 4 or more)
        val selectedCount = listOf(firstAid, sewing, childMinding, cooking, gardenMaintenance, landscaping).count { it }
        val discountAmount = when (selectedCount) {
            2 -> preTotalAmount * 0.05
            3 -> preTotalAmount * 0.10
            in 4..Int.MAX_VALUE -> preTotalAmount * 0.15
            else -> 0.0
        }

        // Show discount in its textview
        discount.text = "Discount: R${discountAmount.toInt()}"

        // Calculate total after discount
        val totalAfterDiscount = preTotalAmount - discountAmount

        // Add VAT (15%)
        val vatAmount = totalAfterDiscount * 0.15
        vat.text = "VAT: R${vatAmount.toInt()}"

        // Final total calculation
        val total = totalAfterDiscount + vatAmount.toInt()

        // Display the total fees in the TextView
        totalFees.text = "Total Fees: R$total"
        Toast.makeText(this, "Fees Calculated", Toast.LENGTH_SHORT).show()
    }
}
