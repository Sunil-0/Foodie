package com.example.foodie

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast

class userData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_data)

        val sp : SharedPreferences = this.getSharedPreferences(file, MODE_PRIVATE)

        val user_name = findViewById<TextView>(R.id.user_name)
        val user_email = findViewById<TextView>(R.id.user_email)
        val user_mobile = findViewById<TextView>(R.id.user_mobile)
        val user_address = findViewById<TextView>(R.id.user_address)
        val user_city = findViewById<TextView>(R.id.user_city)
        val user_pincode = findViewById<TextView>(R.id.user_pincode)

        user_name.text = sp.getString("reg_name", " ")
        user_email.text = sp.getString("reg_email", " ")
        user_mobile.text = sp.getString("reg_mobile", " ")
        user_address.text = sp.getString("reg_address", " ")
        user_city.text = sp.getString("reg_city", " ")
        user_pincode.text = sp.getString("reg_pincode", " ")


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