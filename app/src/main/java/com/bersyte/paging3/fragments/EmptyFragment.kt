package com.bersyte.paging3.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bersyte.paging3.R
import com.bersyte.paging3.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment() {

    private lateinit var binding: FragmentEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            binding.imageLoading.setImageResource(R.drawable.ic_loading_second);

        }, 1000)

        Handler().postDelayed({
            binding.imageLoading.setImageResource(R.drawable.ic_loading_third);
        }, 2000)

        Handler().postDelayed({
            binding.imageLoading.setImageResource(R.drawable.ic_loading_four);

        }, 3000)

        Handler().postDelayed({
            view.findNavController().navigate(R.id.action_emptyFragment_to_firstFragment)
        }, 4000)

    }

}