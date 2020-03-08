package com.example.mediamonkschallenge.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.model.Photos
import com.squareup.picasso.Picasso

class PhotosAdapter (private val list: List<Photos>, private val clickListener: OnPhotosClickListener)
    : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from (parent.context)
        return PhotoViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        var photos : Photos = list [position]
        holder.bind(photos, clickListener)
    }

    interface OnPhotosClickListener {
        fun onPhotoClick(image: String, title: String)
    }

    class PhotoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_photo, parent, false)) {

        var title: TextView? = null
        var image: ImageView? = null

        init {
            title = itemView.findViewById(R.id.titlePhoto)
            image = itemView.findViewById(R.id.imagePhoto)
        }

        fun bind(photos: Photos, productClickListener: OnPhotosClickListener) {
            title?.text = photos.title
            image?.setImageUrl(photos.thumbnailUrl)
            itemView.setOnClickListener{
                productClickListener.onPhotoClick(photos.thumbnailUrl, photos.title)
            }
        }


        fun ImageView.setImageUrl(url: String?) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_loading)
                .into(this)
        }

    }
}
