package com.example.foodie

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*


class MyListAdapter(private val context: Activity,
                    private val img_array: Array<Int>,
                    private val name_array: Array<String>,
                    private val cost_array: Array<Int>,
                    private val detail_array: Array<String>,
                    )
    : ArrayAdapter<String>(context, R.layout.custom_list, name_array)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val imgView = rowView.findViewById<ImageView>(R.id.item_Img)
        val nametext = rowView.findViewById<TextView>(R.id.item_name)
        val costtext = rowView.findViewById<TextView>(R.id.item_cost)
        val detailtext = rowView.findViewById<TextView>(R.id.item_detail)

        imgView.setImageResource(img_array[position])
        nametext.text = name_array[position]
        costtext.text = "₹" + cost_array[position].toString()
        detailtext.text = detail_array[position]

        return rowView

    }
}