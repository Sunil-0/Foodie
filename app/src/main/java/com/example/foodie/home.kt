package com.example.foodie

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlin.math.cos

class home : AppCompatActivity() {
    val file = "foodieSharedPreference";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home)


        val sp : SharedPreferences = this.getSharedPreferences(file, MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        val headerText = findViewById<TextView>(R.id.header)
        headerText.text = "Hello " + sp.getString("reg_name", "")
        val img_array = arrayOf<Int>(
            R.drawable.chicken_biryani,
            R.drawable.fishbiryani,
            R.drawable.paneer_biryani,
            R.drawable.chicken_65,
            R.drawable.chicken_tikka,
            R.drawable.chilli_prawns,
            R.drawable.tandoori_paneer,
            R.drawable.angry_bird_cake,
            R.drawable.strawberry_pastry,
            R.drawable.pineapple,
            R.drawable.butter_naan,
            R.drawable.roomali_roti,

        )
        val name_array = arrayOf<String>(
            "Chicken Biryani",
            "Fish Biryani",
            "Paneer Biryani",
            "Chicken 65",
            "Chicken Tikka",
            "Chilli Prawns",
            "Paneer Pizza",
            "AngryBird Cake",
            "Strawberry Cake",
            "Pineapple Cake",
            "Butter Naan",
            "Rumali Roti"
        )
        val cost_array = arrayOf<Int>(
            220, 280, 190, 250, 250, 280, 180, 550, 80, 420, 25, 15
        )
        val detail_array = arrayOf<String>(
            "Chicken Biryani Full ((Serves With Two Piece of Chicken, Mirchi Ka Salan,Dahi Ka Chutney And Salad)",
            "Fish Biryani Full ((Serves With Two Piece of Boneless fish, Mirchi Ka Salan,Dahi Ka Chutney And Salad)",
            "Paneer Biryani Full ((Serves With 8 Piece of paneer, Mirchi Ka Salan,Dahi Ka Chutney And Salad)",
            "Succulent chicken chunks dipped in a seasoned batter and fried to golden perfection served with a dip.",
            "sufficient for 2. Served With Green Chutney.",
            "Loose prawns are crispy and spicy snack or appetizer made with prawn batter coated and deep fried",
            "sufficient for 2. Served With Green Chutney.",
            "Angry Bird artisanal arranged on our freshly made cakes to offer you an unmatched taste.",
            "Nothing could be more French than a Pastry. Pastries are edible love. Try our cheesecake pastry to know it for yourself.",
            "Pineapple goes on Pizza or Not? It definitely goes well with our perfect and freshly prepared cakes.",
            "",
            ""
        )

        val list_view = findViewById<ListView>(R.id.listView)
        val my_list_adapter = MyListAdapter(this, img_array, name_array, cost_array, detail_array)
        list_view.adapter = my_list_adapter

        list_view.setOnItemClickListener(){ AdapterView, view, position, id ->
            val id = AdapterView.getItemIdAtPosition(position).toInt()
            val cart_name = name_array[id]
            val cart_cost = cost_array[id]
            val cart_img = img_array[id]
            val cart_detail = detail_array[id]
            editor.putString("cart_name", cart_name)
            editor.putInt("cart_cost", cart_cost)
            editor.putInt("cart_img", cart_img)
            editor.putString("cart_detail", cart_detail)
            editor.commit()

            val intent = Intent(this, cartView::class.java)
            startActivity(intent)
        }

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