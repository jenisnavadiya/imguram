package com.jenis.imguram.ui.stories
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jenis.imguram.data.ImgurRepository
import com.jenis.libimgur.models.TagsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {
    private  val repo = ImgurRepository()
    private val _stories = MutableLiveData<List<TagsResponse.Data.Tag?>>()

    val stories: LiveData<List<TagsResponse.Data.Tag?>> = _stories

    fun getTags() {
        viewModelScope.launch (Dispatchers.IO) {
            _stories.postValue(repo.getStories())
            }
        }

}