package com.jenis.imguram.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jenis.imguram.data.ImgurRepository
import com.jenis.libimgur.models.GalleryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private  val repo = ImgurRepository()
    private val _feed = MutableLiveData<List<GalleryResponse.Data>>()

    val feed: LiveData<List<GalleryResponse.Data>> = _feed

    fun updateFeed(feedType: String) {
        viewModelScope.launch (Dispatchers.IO) {
            when (feedType) {
                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())
            }
        }
    }
}