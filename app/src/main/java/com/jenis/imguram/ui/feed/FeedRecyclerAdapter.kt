package com.jenis.imguram.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jenis.imguram.R
import com.jenis.imguram.databinding.ListItemGalleryImageBinding
import com.jenis.libimgur.models.GalleryResponse

class FeedRecyclerAdapter():
    ListAdapter<GalleryResponse.Data, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallback()) {

  class FeedViewHolder(val binding: ListItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root)

    private class FeedDiffCallback: DiffUtil.ItemCallback<GalleryResponse.Data>() {
        override fun areItemsTheSame(
            oldItem: GalleryResponse.Data,
            newItem: GalleryResponse.Data
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: GalleryResponse.Data,
            newItem: GalleryResponse.Data
        ): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding.captionTextView.text = image.title
        holder.binding.imageView.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.placeholder_image)
            error(R.drawable.placeholder_image)
        }
    }
}