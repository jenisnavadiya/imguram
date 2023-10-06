package com.jenis.imguram.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jenis.imguram.R
import com.jenis.imguram.databinding.ActivityMainBinding
import com.jenis.imguram.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoryBinding
    private val storyViewModel by viewModels<StoryViewModel>()
    private val storyAdapter = StoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tagImageViewPager.apply {
            adapter = storyAdapter
        }

        intent.getStringExtra("tag")?.let {
            storyViewModel.getTags(it)
        }
    }

    override fun onResume() {
        super.onResume()
        storyViewModel.stories.observe(this) {
            storyAdapter.submitList(it)
        }
    }
}