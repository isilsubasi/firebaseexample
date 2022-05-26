package com.isilsubasi.isilfirebase.service

import com.isilsubasi.isilfirebase.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiHelper {


    @GET("(default)/documents/user")
    fun getUser(): Call<UserResponse>

}