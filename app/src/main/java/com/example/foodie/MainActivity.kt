package com.example.foodie

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val file = "foodieSharedPreference";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val sample = findViewById<TextView>(R.id.sample)

        val sp: SharedPreferences = this.getSharedPreferences(file, Context.MODE_PRIVATE);

        val editor: SharedPreferences.Editor = sp.edit();

        val recyclerview = findViewById<RecyclerView>(R.id.recycler)
        val userID = findViewById<EditText>(R.id.userid)
        val password = findViewById<EditText>(R.id.password)
        val regBtn = findViewById<TextView>(R.id.regBtn)
        val loginBtn = findViewById<Button>(R.id.loginBtn)



        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        val mlist = ArrayList<loginModel>()
        mlist.add(loginModel(R.drawable.login_img1))
        mlist.add(loginModel(R.drawable.login_img2))
        mlist.add(loginModel(R.drawable.login_img3))
        mlist.add(loginModel(R.drawable.login_img4))
        mlist.add(loginModel(R.drawable.login_img5))

        val adapter = loginAdapter(mlist)
        recyclerview.adapter = adapter

        loginBtn.setOnClickListener(){
            val userID_val = userID.text.toString().trim()
            val password_val = password.text.toString().trim()
            val reg_email = sp.getString("reg_email", "").toString()
            val reg_password = sp.getString("reg_password", "").toString()
            val intent = Intent(this, home::class.java)

            if(userID_val.isEmpty()){
                Toast.makeText(applicationContext, "Enter Email", Toast.LENGTH_SHORT).show()
            }
            else if(userID_val != reg_email){
                Toast.makeText(applicationContext, "Wrong Email", Toast.LENGTH_SHORT).show()
            }
            else if(password_val.isEmpty()){
                Toast.makeText(applicationContext, "Enter Password", Toast.LENGTH_SHORT).show()
            }
            else if(password_val != reg_password){
                Toast.makeText(applicationContext, "Wrong Password", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
            }
        }

        regBtn.setOnClickListener(){
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }


    }
}