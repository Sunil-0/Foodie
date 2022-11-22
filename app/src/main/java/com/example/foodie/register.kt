package com.example.foodie

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

val file = "foodieSharedPreference";
class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val reg_name = findViewById<EditText>(R.id.reg_name)
        val reg_email = findViewById<EditText>(R.id.reg_email)
        val reg_password = findViewById<EditText>(R.id.reg_password)
        val reg_mobile = findViewById<EditText>(R.id.reg_mobile)
        val reg_address = findViewById<EditText>(R.id.reg_address)
        val reg_city = findViewById<EditText>(R.id.reg_city)
        val reg_pincode = findViewById<EditText>(R.id.reg_pincode)

        val sp: SharedPreferences = this.getSharedPreferences(file, Context.MODE_PRIVATE);
        val editor: SharedPreferences.Editor = sp.edit();


        val gotoLoginBtn = findViewById<TextView>(R.id.gotoLoginBtn)
        val RegisterBtn = findViewById<Button>(R.id.RegisterBtn)

        RegisterBtn.setOnClickListener(){
            editor.putString("reg_name", reg_name.text.toString());
            editor.putString("reg_email", reg_email.text.toString());
            editor.putString("reg_mobile", reg_mobile.text.toString());
            editor.putString("reg_password", reg_password.text.toString());
            editor.putString("reg_address", reg_address.text.toString());
            editor.putString("reg_city", reg_city.text.toString());
            editor.putString("reg_pincode", reg_pincode.text.toString());


            editor.commit()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);

        }

        gotoLoginBtn.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}