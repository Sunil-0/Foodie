package com.example.foodie

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class cartView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_view)

        val sp: SharedPreferences = this.getSharedPreferences(file, Context.MODE_PRIVATE);

        val cart_name = findViewById<TextView>(R.id.cart_name)
        val cart_detail = findViewById<TextView>(R.id.cart_detail)
        val cart_img = findViewById<ImageView>(R.id.cart_Img)
        val cartItemName = findViewById<TextView>(R.id.cartitemname)
        val cartItemCost = findViewById<TextView>(R.id.cartitemcost)
        val orderBtn = findViewById<Button>(R.id.orderbtn)

        cart_name.text = sp.getString("cart_name", " ")
        cart_detail.text = sp.getString("cart_detail", " ")
        cart_img.setImageResource(sp.getInt("cart_img", 0))
        cartItemName.text = "Cost of " + sp.getString("cart_name", " ") + " "
        cartItemCost.text = "₹" + sp.getInt("cart_cost", 0)

        orderBtn.text = "Order     ₹" + (sp.getInt("cart_cost", 0).toInt() + 38)
    }
}