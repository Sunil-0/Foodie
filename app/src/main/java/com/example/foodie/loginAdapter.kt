package com.example.foodie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class loginAdapter(val mlist:List<loginModel>) : RecyclerView.Adapter<loginAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): loginAdapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: loginAdapter.MyViewHolder, position: Int) {
        val item = mlist[position]
        holder.iv.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var iv: ImageView = itemView.findViewById(R.id.iv) as ImageView

    }
}