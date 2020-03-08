package com.example.mediamonkschallenge.view.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.model.Albums

class AlbumsAdapter (private val list: List<Albums>)
    : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        return AlbumsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        var albums : Albums = list [position]
        holder.bind(albums)
    }

    class AlbumsViewHolder (inflater: LayoutInflater, parent:ViewGroup) :
            RecyclerView.ViewHolder(inflater.inflate(R.layout.item_album, parent, false)){

        var title : TextView? = null

        init {
            title = itemView.findViewById(R.id.title)
        }

        fun bind (albums: Albums){
            title?.text = albums.title
        }

    }

}