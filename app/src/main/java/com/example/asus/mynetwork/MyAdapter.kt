package com.example.asus.mynetwork

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.opengl.Visibility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MyAdapter(private val news: List<New>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    inner class MyViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal val iconView: ImageView = view.findViewById(R.id.avatar) as ImageView
        internal val imageView: ImageView = view.findViewById(R.id.image) as ImageView
        internal val nameView: TextView = view.findViewById(R.id.name)
        internal val textView: TextView = view.findViewById(R.id.text)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val new = news[position]
        if(new.type == "News") {
            Glide.with(holder.itemView.context).load(new.img).apply(RequestOptions.centerCropTransform())
                .into(holder.imageView)

            holder.iconView.visibility = View.GONE

        }else{
            Glide.with(holder.itemView.context).load(new.img).apply(RequestOptions.centerCropTransform())
                .into(holder.iconView)

            holder.imageView.visibility = View.GONE
        }
        holder.nameView.text = new.name
        holder.textView.text = new.text

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size
}