package com.bersyte.paging3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bersyte.paging3.R
import com.bersyte.paging3.adapter.CharacterAdapter
import com.bersyte.paging3.databinding.ActivityMainBinding
import com.bersyte.paging3.databinding.FragmentFirstBinding
import com.bersyte.paging3.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var characterAdapter: CharacterAdapter
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)

        setupRecyclerView()
        loadData()
        return binding.root
    }

    private fun setupRecyclerView() {

        characterAdapter = CharacterAdapter()

        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
        }

    }

    private fun loadData() {

        lifecycleScope.launch {
            viewModel.listData.collect {

                Log.d("aaa", "load: $it")
                characterAdapter.submitData(it)
            }

        }
    }

}