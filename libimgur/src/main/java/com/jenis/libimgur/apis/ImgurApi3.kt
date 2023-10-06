package com.jenis.libimgur.apis

import com.jenis.libimgur.enums.SectionEnum
import com.jenis.libimgur.models.GalleryResponse
import com.jenis.libimgur.models.TagsGalleryResponse
import com.jenis.libimgur.models.TagsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurApi3 {

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>

    @GET("gallery/{section}")
    suspend fun getGallery(
        @Path("section") section: SectionEnum,
        @Query("album_previews") albumPreviews: Boolean? = true

    ): Response<GalleryResponse>

    @GET("gallery/t/{tagName}")
    suspend fun getTagsGallery(@Path("tagName") tagName: String): Response<TagsGalleryResponse>

}