package com.bersyte.paging3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.bersyte.paging3.R
import com.bersyte.paging3.databinding.FragmentDetailBinding
import com.bersyte.paging3.databinding.FragmentFirstBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailBinding.inflate(layoutInflater)

        activity?.findViewById<View>(R.id.switchLayouts)!!.visibility = View.INVISIBLE
        activity?.findViewById<View>(R.id.rightView)!!.visibility = View.INVISIBLE
        activity?.findViewById<View>(R.id.leftView)!!.visibility = View.INVISIBLE
        activity?.findViewById<View>(R.id.backButton)!!.visibility = View.VISIBLE
        activity?.findViewById<View>(R.id.backButton)!!.setOnClickListener {

            findNavController(activity?.findViewById<View>(R.id.nav_host_fragment)!!).navigate(R.id.secondFragment)

        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        activity?.findViewById<View>(R.id.switchLayouts)!!.visibility = View.VISIBLE
        activity?.findViewById<View>(R.id.rightView)!!.visibility = View.VISIBLE
        activity?.findViewById<View>(R.id.leftView)!!.visibility = View.VISIBLE
        activity?.findViewById<View>(R.id.backButton)!!.visibility = View.INVISIBLE
    }

}