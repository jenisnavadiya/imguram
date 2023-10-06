package com.jenis.libimgur.apis

import com.jenis.libimgur.ImgurClient
import com.jenis.libimgur.enums.SectionEnum
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurApi3Tests {
    private val api = ImgurClient.api

    @Test
    fun `get Tags Working`() = runBlocking {
        val response = api.getTags()
        println(response.raw().toString())
        assertNotNull(response.body())
    }

    @Test
    fun `get Gallery - hot Working`() = runBlocking {
        val response = api.getGallery(section = SectionEnum.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun `get Gallery - top Working`() = runBlocking {
        val response = api.getGallery(section = SectionEnum.TOP)
        assertNotNull(response.body())
    }

    @Test
    fun `get Tags Gallery Working`() = runBlocking {
        val response = api.getTagsGallery("funny")
        assertNotNull(response.body())
    }
}