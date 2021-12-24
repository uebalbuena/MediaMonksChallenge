package com.example.mediamonkschallenge.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mediamonkschallenge.model.Albums
import com.example.mediamonkschallenge.service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumsViewModel : ViewModel() {

    private var albumsList : MutableLiveData<List<Albums>>? = null

    fun getAlbums() : LiveData<List<Albums>> {
        if (albumsList == null){
            albumsList = MutableLiveData<List<Albums>>()
            loadAlbumsList()
        }
        return albumsList as MutableLiveData<List<Albums>>
    }

    private fun loadAlbumsList() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getAlbums()

        call.enqueue(object : Callback<List<Albums>>{
            override fun onFailure(call: Call<List<Albums>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Albums>>, response: Response<List<Albums>>) {
                albumsList!!.value = response.body()
            }
        })
    }
}
