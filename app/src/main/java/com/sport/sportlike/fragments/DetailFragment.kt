package com.sport.sportlike.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.sport.sportlike.R
import com.sport.sportlike.adapter.SportAdapter
import com.sport.sportlike.databinding.FragmentDetailBinding

var sporAdapter = SportAdapter()

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

        sporAdapter.setOnItemClickListenerString{
            var m = it
            binding.textViewSportName.text = it

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