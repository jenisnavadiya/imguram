package com.jenis.imguram.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jenis.imguram.data.ImgurRepository
import com.jenis.libimgur.models.TagsGalleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {

    private  val repo = ImgurRepository()
    private val _images = MutableLiveData<List<TagsGalleryResponse.Data.Item?>>()

    val stories: LiveData<List<TagsGalleryResponse.Data.Item?>> = _images

    fun getTags(tagName: String) {
        viewModelScope.launch (Dispatchers.IO) {
            _images.postValue(repo.getTagsGallery(tagName))
        }
    }
}