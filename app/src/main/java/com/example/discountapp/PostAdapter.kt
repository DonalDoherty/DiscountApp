package com.example.discountapp

import android.R
import android.net.Uri
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.discountapp.models.Post
import com.example.discountapp.R.layout.recycler_list_rows
import kotlinx.android.synthetic.main.recycler_list_rows.*
import kotlinx.android.synthetic.main.recycler_list_rows.view.*


class PostAdapter(private val postsList: List<Post>) :
    RecyclerView.Adapter<PostAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(recycler_list_rows, parent, false)
        return MyViewHolder(itemView)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var thumbnail = view.post_thumb_row
        var title = view.post_title_row
        var userName = view.post_username_row
        var prevPrice = view.post_prevPrice_row
        var currentPrice = view.post_currentPrice_row
        var expDate = view.post_expiry_row
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postsList[position]
        holder.thumbnail.setImageURI(Uri.parse(post.imgUrl))
        holder.title.setText(post.title)
        holder.userName.setText(post.postCreator)
        holder.prevPrice.setText(post.prevPrice.toString())
        holder.currentPrice.setText(post.curPrice.toString())
        holder.expDate.setText(post.expDate)

    }

    override fun getItemCount(): Int {
        return postsList.size
    }


}