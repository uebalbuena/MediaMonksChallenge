package com.example.mediamonkschallenge.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.databinding.FragmentPhotoDetailBinding
import com.example.mediamonkschallenge.viewModel.PhotosViewModel
import com.squareup.picasso.Picasso

class PhotoDetailFragment : Fragment() {

    private val viewModel : PhotosViewModel by activityViewModels()
    private lateinit var photoDetailBinding: FragmentPhotoDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        photoDetailBinding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        return photoDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photoDetailBinding.titleDetail.text = viewModel.title.value
        photoDetailBinding.imageDetail.setImageUrl(viewModel.image.value)
        photoDetailBinding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_photoDetailFragment_to_photosFragment)
        }
    }

        private fun ImageView.setImageUrl(url: String?) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_loading)
                .into(this)
        }
}
