package com.isilsubasi.isilfirebase.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        const val baseUrl = "https://firestore.googleapis.com/v1/projects/isilfirebase-91003/databases/"
        fun getApi(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}