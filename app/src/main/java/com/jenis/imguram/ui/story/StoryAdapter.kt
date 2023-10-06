package com.jenis.imguram.ui.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jenis.imguram.R
import com.jenis.imguram.databinding.ListItemTagImageBinding
import com.jenis.libimgur.models.TagsGalleryResponse

class StoryAdapter() :
    ListAdapter<TagsGalleryResponse.Data.Item, StoryAdapter.StoryViewHolder>(StoryDiffCallback()) {

    class StoryViewHolder(val binding: ListItemTagImageBinding) : RecyclerView.ViewHolder(binding.root)

    class StoryDiffCallback() : DiffUtil.ItemCallback<TagsGalleryResponse.Data.Item>() {
        override fun areItemsTheSame(
            oldItem: TagsGalleryResponse.Data.Item,
            newItem: TagsGalleryResponse.Data.Item
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TagsGalleryResponse.Data.Item,
            newItem: TagsGalleryResponse.Data.Item
        ): Boolean {
            return oldItem.toString() == newItem.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemTagImageBinding.inflate(inflater,parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.tagImageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }
}