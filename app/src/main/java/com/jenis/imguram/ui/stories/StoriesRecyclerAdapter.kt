package com.jenis.imguram.ui.stories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jenis.imguram.R
import com.jenis.imguram.databinding.ListItemStoryImageBinding
import com.jenis.libimgur.models.TagsResponse

class StoriesRecyclerAdapter() :
    ListAdapter<TagsResponse.Data.Tag, StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallback()) {
    class StoriesViewHolder(val binding: ListItemStoryImageBinding) : RecyclerView.ViewHolder(binding.root)

    class StoriesDiffCallback : DiffUtil.ItemCallback<TagsResponse.Data.Tag>() {
        override fun areItemsTheSame(
            oldItem: TagsResponse.Data.Tag,
            newItem: TagsResponse.Data.Tag
        ): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TagsResponse.Data.Tag,
            newItem: TagsResponse.Data.Tag
        ): Boolean {
            return  oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryImageBinding.inflate(inflater,parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.displayName
        holder.binding.imageView.load("https://i.imgur.com/${image.backgroundHash}.jpg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }

}