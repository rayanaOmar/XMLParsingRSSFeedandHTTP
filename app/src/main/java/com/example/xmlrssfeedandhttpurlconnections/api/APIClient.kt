package com.example.xmlrssfeedandhttpurlconnections.api

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class APIClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com/r/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        return retrofit
    }
}