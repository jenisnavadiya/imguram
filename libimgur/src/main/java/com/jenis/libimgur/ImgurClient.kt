package com.jenis.libimgur

import com.jenis.libimgur.apis.ImgurApi3
import com.jenis.libimgur.converters.EnumConverterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

   // TODO(jenis): [API_KEY] should be Empty when push
    private const val API_KEY = "89822a7fd6fcbaf"

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor {
            val request =
                it.request().newBuilder().addHeader("Authorization", "Client-ID $API_KEY").build()
            it.proceed(request)
        }.build()
    }


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(httpClient).addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("https://api.imgur.com/3/").build()
    }

    val api: ImgurApi3 by lazy {
        retrofit.create(ImgurApi3::class.java)
    }
}