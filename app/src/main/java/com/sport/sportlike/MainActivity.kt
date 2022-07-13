package com.sport.sportlike

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.sport.sportlike.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

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