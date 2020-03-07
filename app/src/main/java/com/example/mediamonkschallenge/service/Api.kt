package com.example.mediamonkschallenge.service

import com.example.mediamonkschallenge.model.Albums
import com.example.mediamonkschallenge.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/photos")
    fun getPhotos(): Call<List<Photos>>

    @GET("/albums")
    fun getAlbums(): Call<List<Albums>>
    
}