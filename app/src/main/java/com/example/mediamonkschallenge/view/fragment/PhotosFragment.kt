package com.example.mediamonkschallenge.view.fragment

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.model.Photos
import com.example.mediamonkschallenge.view.adapter.PhotosAdapter
import com.example.mediamonkschallenge.viewModel.PhotosViewModel
import kotlinx.android.synthetic.main.item_photo.*
import kotlinx.android.synthetic.main.photos_fragment.*

class PhotosFragment : Fragment(), PhotosAdapter.OnPhotosClickListener{

    val photosViewModel : PhotosViewModel by activityViewModels()

    var photosAdapter : PhotosAdapter? = null

    private var mContext : Context? = null


    override fun onPhotoClick(image: String, title: String) {
        photosViewModel.saveStrings(image, title)
        findNavController().navigate(R.id.action_photosFragment_to_photoDetailFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photos_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPhotos()

        buttonAlbum.setOnClickListener(View.OnClickListener {
            buttonAlbum.findNavController().navigate(R.id.action_photosFragment_to_albumsFragment)
        })
    }

    override fun onResume() {
        super.onResume()
        getPhotos()
    }

    fun getPhotos() {
        photosViewModel!!.getPhotos().observe(this, Observer <List<Photos>> { photoList ->
            prepareRecyclerView(photoList)
        })
    }

    private fun prepareRecyclerView(photoList : List<Photos>){
        photosAdapter = PhotosAdapter(photoList, this)
        recyclerPhotos.setLayoutManager(LinearLayoutManager(mContext))
        recyclerPhotos.setItemAnimator(DefaultItemAnimator())
        recyclerPhotos.setAdapter(photosAdapter)
    }



}
