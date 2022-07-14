package com.sport.sportlike.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sport.sportlike.R
import com.sport.sportlike.adapter.SportAdapter
import com.sport.sportlike.databinding.FragmentDetailBinding

var sporAdapter = SportAdapter()

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val arguments :DetailFragmentArgs by navArgs()


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

            binding.textviewCalender.text = arguments.id.calendar
            binding.textFirstTeamName.text = arguments.id.nameOne
            binding.textSecondTeamName.text = arguments.id.nameSecond
            binding.winFirstScore.text = arguments.id.rateOne
            binding.drawScore.text = arguments.id.rateTwo
            binding.winSecondScore.text = arguments.id.rateThird
            binding.matchScore.text = arguments.id.score

        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.id.imageOneUrl}.png").into(binding.imageTeamOne)
        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${arguments.id.imageSecondUrl}.png").into(binding.imageTeamSecond)

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