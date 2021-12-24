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
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.databinding.AlbumsFragmentBinding
import com.example.mediamonkschallenge.model.Albums
import com.example.mediamonkschallenge.view.adapter.AlbumsAdapter
import com.example.mediamonkschallenge.viewModel.AlbumsViewModel

class AlbumsFragment : Fragment() {

    private val albumsViewModel : AlbumsViewModel by activityViewModels()
    private lateinit var albumsBinding: AlbumsFragmentBinding
    private var albumsAdapter : AlbumsAdapter? = null
    private var mContext : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAlbums()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        albumsBinding = AlbumsFragmentBinding.inflate(inflater, container, false)
        return albumsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        albumsBinding.buttonPhoto.setOnClickListener{
            albumsBinding.buttonPhoto.findNavController().navigate(R.id.action_albumsFragment_to_photosFragment)
        }
        getAlbums()
    }

    override fun onResume() {
        super.onResume()
        getAlbums()
    }

    private fun getAlbums(){
        albumsViewModel.getAlbums().observe(this, Observer <List<Albums>> { albumsList ->
            prepareRecyclerView(albumsList)
            albumsBinding.progressAlbum.visibility = View.GONE
        })
    }

    private fun prepareRecyclerView(albumsList: List<Albums>){
        albumsAdapter = AlbumsAdapter(albumsList)
        albumsBinding.recyclerAlbums.layoutManager = LinearLayoutManager(mContext)
        albumsBinding.recyclerAlbums.itemAnimator = DefaultItemAnimator()
        albumsBinding.recyclerAlbums.adapter = albumsAdapter
    }
}
