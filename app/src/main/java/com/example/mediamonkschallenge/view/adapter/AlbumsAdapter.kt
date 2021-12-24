package com.example.mediamonkschallenge.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkschallenge.databinding.ItemAlbumBinding
import com.example.mediamonkschallenge.model.Albums

class AlbumsAdapter (private val list: List<Albums>)
    : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {

    private lateinit var albumItemBinding: ItemAlbumBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        albumItemBinding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumsViewHolder(albumItemBinding.root)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        val albums : Albums = list [position]
        holder.bind(albums)
    }

    inner class AlbumsViewHolder (view: View) : RecyclerView.ViewHolder(view){
        private var title : TextView = albumItemBinding.title
        fun bind (albums: Albums){
            title.text = albums.title
        }
    }
}