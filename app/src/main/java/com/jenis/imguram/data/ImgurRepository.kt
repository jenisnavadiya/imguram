package com.jenis.imguram.data

import com.jenis.libimgur.ImgurClient
import com.jenis.libimgur.enums.SectionEnum
import com.jenis.libimgur.models.GalleryResponse

class ImgurRepository {
    private val api = ImgurClient.api

    suspend fun getHotFeed(): List<GalleryResponse.Data>? {
        val response = api.getGallery(section = SectionEnum.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<GalleryResponse.Data>? {
        val response = api.getGallery(section = SectionEnum.TOP)
        return response.body()?.data
    }
}