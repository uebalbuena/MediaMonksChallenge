package com.example.mediamonkschallenge.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.viewModel.PhotosViewModel

class PhotosFragment : Fragment() {

    companion object {
        fun newInstance() = PhotosFragment()
    }

    private lateinit var viewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PhotosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
