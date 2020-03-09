package com.example.mediamonkschallenge.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

import com.example.mediamonkschallenge.R
import com.example.mediamonkschallenge.viewModel.PhotosViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_photo_detail.*

/**
 * A simple [Fragment] subclass.
 */
class PhotoDetailFragment : Fragment() {

    private val viewModel : PhotosViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleDetail.text = viewModel.title.value
        imageDetail.setImageUrl(viewModel.image.value)

        backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_photoDetailFragment_to_photosFragment)
        })

    }

        fun ImageView.setImageUrl(url: String?) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_loading)
                .into(this)
        }

}
