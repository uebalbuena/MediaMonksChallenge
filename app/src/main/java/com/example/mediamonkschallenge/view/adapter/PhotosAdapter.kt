package com.example.mediamonkschallenge.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.databinding.ItemPhotoBinding
import com.example.mediamonkschallenge.model.Photos
import com.squareup.picasso.Picasso

class PhotosAdapter (private val list: List<Photos>, private val clickListener: OnPhotosClickListener)
    : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private lateinit var photoItemBinding: ItemPhotoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        photoItemBinding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(photoItemBinding.root)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photos : Photos = list [position]
        holder.bind(photos, clickListener)
    }

    interface OnPhotosClickListener {
        fun onPhotoClick(image: String, title: String)
    }

    inner class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var title: TextView? = null
        private var image: ImageView? = null

        init {
            title = photoItemBinding.titlePhoto
            image = photoItemBinding.imagePhoto
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
