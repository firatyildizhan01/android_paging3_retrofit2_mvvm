package com.bersyte.paging3

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bersyte.paging3.databinding.ActivityMainBinding
import com.bersyte.paging3.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ballLayout.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.firstFragment)
            binding.leftView.visibility = View.VISIBLE
            binding.rightView.visibility = View.INVISIBLE
        }

        binding.menuLayout.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.secondFragment)
            binding.leftView.visibility = View.INVISIBLE
            binding.rightView.visibility = View.VISIBLE
        }

        Handler().postDelayed({
            binding.switchLayouts.visibility = View.VISIBLE
        }, 4000)
    }
}