package com.example.foodie

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_order)

        val sp : SharedPreferences = this.getSharedPreferences(file, MODE_PRIVATE)
        val order_address = findViewById<TextView>(R.id.order_address)

        order_address.text = sp.getString("reg_address", "") + ", " + sp.getString("reg_city", "")

        val homeIcon = findViewById<TextView>(R.id.homeIcon)
        val foodIcon = findViewById<TextView>(R.id.foodIcon)
        val userIcon = findViewById<TextView>(R.id.userIcon)

        homeIcon.setOnClickListener(){
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
        foodIcon.setOnClickListener(){
            val intent = Intent(this, cartView::class.java)

            startActivity(intent)
        }
        userIcon.setOnClickListener(){
            val intent = Intent(this, userData::class.java)

            startActivity(intent)
        }
    }
}