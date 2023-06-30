package com.app.tupplecompany.api

import com.app.tupplecompany.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    fun getUserList():Call<MutableList<UserData>>

    fun onNameSubmitted(name: String)
}