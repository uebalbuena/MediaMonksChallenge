package com.example.mediamonkschallenge.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mediamonkschallenge.model.Photos
import com.example.mediamonkschallenge.service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosViewModel : ViewModel() {

    var image = MutableLiveData<String>()
    var title = MutableLiveData<String>()

    private var photoList : MutableLiveData<List<Photos>>? = null

    fun getPhotos() : LiveData<List<Photos>>{
        if (photoList == null){
            photoList = MutableLiveData <List<Photos>>()
            loadPhotoList()
        }
        return photoList as MutableLiveData <List<Photos>>
    }

    private fun loadPhotoList() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getPhotos()

        call.enqueue(object : Callback<List<Photos>>{
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                photoList!!.value = response.body()
            }
        })

    }
    fun saveStrings (image: String, title: String){
        this.image.value = image
        this.title.value = title
    }
}
