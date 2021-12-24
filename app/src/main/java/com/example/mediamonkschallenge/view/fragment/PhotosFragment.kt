package com.example.mediamonkschallenge.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.databinding.PhotosFragmentBinding
import com.example.mediamonkschallenge.model.Photos
import com.example.mediamonkschallenge.view.adapter.PhotosAdapter
import com.example.mediamonkschallenge.viewModel.PhotosViewModel

class PhotosFragment : Fragment(), PhotosAdapter.OnPhotosClickListener{

    private val photosViewModel : PhotosViewModel by activityViewModels()
    private lateinit var photosBinding: PhotosFragmentBinding
    private var photosAdapter : PhotosAdapter? = null
    private var mContext : Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        photosBinding = PhotosFragmentBinding.inflate(inflater, container, false)
        return photosBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPhotos()

        photosBinding.buttonAlbum.setOnClickListener{
            photosBinding.buttonAlbum.findNavController().navigate(R.id.action_photosFragment_to_albumsFragment)
        }
    }

    override fun onPhotoClick(image: String, title: String) {
        photosViewModel.saveStrings(image, title)
        findNavController().navigate(R.id.action_photosFragment_to_photoDetailFragment)
    }

    override fun onResume() {
        super.onResume()
        getPhotos()
    }

    private fun getPhotos() {
        photosViewModel.getPhotos().observe(this, Observer <List<Photos>> { photoList ->
            prepareRecyclerView(photoList)
            photosBinding.progressPhoto.visibility = View.GONE
        })
    }

    private fun prepareRecyclerView(photoList : List<Photos>){
        photosAdapter = PhotosAdapter(photoList, this)
        photosBinding.recyclerPhotos.layoutManager = LinearLayoutManager(mContext)
        photosBinding.recyclerPhotos.itemAnimator = DefaultItemAnimator()
        photosBinding.recyclerPhotos.adapter = photosAdapter
    }
}
