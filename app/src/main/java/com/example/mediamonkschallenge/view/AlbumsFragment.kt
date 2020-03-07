package com.example.mediamonkschallenge.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.viewModel.AlbumsViewModel

class AlbumsFragment : Fragment() {

    companion object {
        fun newInstance() = AlbumsFragment()
    }

    private lateinit var viewModel: AlbumsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.albums_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AlbumsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
