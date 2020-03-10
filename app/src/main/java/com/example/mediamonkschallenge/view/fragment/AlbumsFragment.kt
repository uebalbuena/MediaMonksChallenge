package com.example.mediamonkschallenge.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.model.Albums
import com.example.mediamonkschallenge.view.adapter.AlbumsAdapter
import com.example.mediamonkschallenge.viewModel.AlbumsViewModel
import kotlinx.android.synthetic.main.albums_fragment.*

class AlbumsFragment : Fragment() {

    val albumsViewModel : AlbumsViewModel by activityViewModels()

    var albumsAdapter : AlbumsAdapter? = null

    private var mContext : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getAlbums()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.albums_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAlbums()

        buttonPhoto.setOnClickListener(View.OnClickListener {
            buttonPhoto.findNavController().navigate(R.id.action_albumsFragment_to_photosFragment)
        })

    }

    override fun onResume() {
        super.onResume()
        getAlbums()
    }

    fun getAlbums(){
        albumsViewModel!!.getAlbums().observe(this, Observer <List<Albums>> { albumsList ->
            prepareRecyclerView(albumsList)
            progressAlbum.visibility = View.GONE
        })
    }

    private fun prepareRecyclerView(albumsList: List<Albums>){
        albumsAdapter = AlbumsAdapter(albumsList)
        recyclerAlbums.setLayoutManager(LinearLayoutManager(mContext))
        recyclerAlbums.setItemAnimator(DefaultItemAnimator())
        recyclerAlbums.setAdapter(albumsAdapter)
    }

}
