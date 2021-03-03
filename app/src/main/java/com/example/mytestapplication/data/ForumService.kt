package com.example.mytestapplication.data

import com.example.mytestapplication.model.DataRandom
import retrofit2.Call
import retrofit2.http.*


interface ForumService {
    @GET("/random_ten")
    fun getDataRandom(): Call<List<DataRandom>>
}