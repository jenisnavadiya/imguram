package com.jenis.imguram.data

import com.jenis.libimgur.ImgurClient
import com.jenis.libimgur.enums.SectionEnum
import com.jenis.libimgur.models.GalleryResponse
import com.jenis.libimgur.models.TagsGalleryResponse
import com.jenis.libimgur.models.TagsResponse

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

    suspend fun getStories(): List<TagsResponse.Data.Tag?>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getTagsGallery(tagName: String): List<TagsGalleryResponse.Data.Item?>? {
        val response = api.getTagsGallery(tagName)
        return response.body()?.data?.items
    }
}