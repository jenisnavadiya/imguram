package com.jenis.imguram

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.SCROLL_AXIS_HORIZONTAL
import com.jenis.imguram.databinding.ActivityMainBinding
import com.jenis.imguram.databinding.FragmentFeedBinding
import com.jenis.imguram.ui.feed.FeedViewModel
import com.jenis.imguram.ui.stories.StoriesRecyclerAdapter
import com.jenis.imguram.ui.stories.StoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdapter =  StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecyclerView.apply {
           layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
            adapter = storiesAdapter

        }
        setupNav()

        storiesViewModel.getTags()
    }

    private fun setupNav() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        storiesViewModel.stories.observe(this) {
           storiesAdapter.submitList(it)
        }
    }
}