package com.sport.sportlike.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sport.sportlike.R
import com.sport.sportlike.databinding.FragmentFirstBinding
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.model.SportModel
import com.sport.sportlike.viewmodel.CharacterViewModel
import com.sport.sportlike.viewmodel.SportViewModel
import com.bumptech.glide.Glide
import com.sport.sportlike.utils.IsOnline
import dagger.hilt.android.AndroidEntryPoint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    var nameOne = ""
    var nameSecond = ""
    var nameRateOne = ""
    var nameRateSecond = ""
    var nameRateThird = ""
    var calendar = ""
    var finishTime = ""
    var imageUrlOne = ""
    var imageUrlSecond = ""
    var score = ""
    var gameid = ""

    private val viewModel: CharacterViewModel by viewModels()
    private val sportViewModel: SportViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(activity?.let { IsOnline().isOnline(it) } == true){randomSelectOnCreate()  }

        activity?.findViewById<View>(R.id.switchLayouts)!!.visibility = View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)


//        activity?.findViewById<View>(R.id.switchLayouts)!!.visibility = View.INVISIBLE


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity?.let { IsOnline().isOnline(it) } == true){randomSelectOnCreate()}



        binding.likeLayout.setOnClickListener(){
            if(activity?.let { IsOnline().isOnline(it) } == true){randomSelectLike()}

        }

        binding.dislikeLayout.setOnClickListener(){
            if(activity?.let { IsOnline().isOnline(it) } == true){randomSelect()}

        }
    }

    fun randomSelect(){

        activity?.let {
            viewModel.sportResponse.observe(it) { spor ->

                binding.apply {

                    val selectedItemList = (0..spor.body.size).random()


                    var globalData = spor.body.elementAtOrNull(selectedItemList)?.events_list?.elementAtOrNull(0)

                    val date = Date((globalData?.game_start ?: 0) * 1000L)
                    val format: DateFormat = SimpleDateFormat("dd.MM")
                    format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
                    val formatted: String = format.format(date)

                    nameOne = globalData?.opp_1_name_en ?: ""
                    nameSecond = globalData?.opp_2_name_en ?: ""
                    nameRateOne = globalData?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString()
                    nameRateSecond = globalData?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString()
                    nameRateThird = globalData?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString()
                    finishTime = ""
                    calendar = formatted
                    imageUrlOne = globalData?.opp_1_icon.toString()
                    imageUrlSecond = globalData?.opp_2_icon.toString()
                    score = globalData?.score_full ?: ""
                    gameid = globalData?.game_id.toString()
                    calendar = formatted

                    textDate.text = formatted
                    textViewSportName.text = globalData?.sport_name_en ?: ""
                    textFirstTeamName.text = globalData?.opp_1_name_en ?: ""
                    textSecondTeamName.text = globalData?.opp_2_name_en ?: ""
                    if (globalData != null) {
                        winFirstScore.text = globalData.game_oc_list.elementAtOrNull(0)?.oc_rate.toString()
                        drawScore.text = globalData.game_oc_list.elementAtOrNull(1)?.oc_rate.toString()
                        winSecondScore.text = globalData.game_oc_list.elementAtOrNull(2)?.oc_rate.toString()
                    }

                    var y = globalData?.opp_1_icon

                    if(globalData?.opp_1_icon != null){
                        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_1_icon}.png").into(binding.imageTeamOne)
                    }

                    if(globalData?.opp_2_icon != null){
                        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_2_icon}.png").into(binding.imageTeamSecond)
                    }
                }
            }
        }
    }

    fun randomSelectOnCreate(){

        activity?.let {
            viewModel.sportResponse.observe(it) { spor ->

                binding.apply {

                    val selectedItemList = (0..spor.body.size).random()


                    var globalData = spor.body.elementAtOrNull(selectedItemList)?.events_list?.elementAtOrNull(0)

                    val date = Date((globalData?.game_start ?: 0) * 1000L)
                    val format: DateFormat = SimpleDateFormat("dd.MM")
                    format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
                    val formatted: String = format.format(date)

                    nameOne = globalData?.opp_1_name_en ?: ""
                    nameSecond = globalData?.opp_2_name_en ?: ""
                    nameRateOne = globalData?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString()
                    nameRateSecond = globalData?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString()
                    nameRateThird = globalData?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString()
                    imageUrlOne = globalData?.opp_1_icon.toString()
                    imageUrlSecond = globalData?.opp_2_icon.toString()
                    score = globalData?.score_full ?: ""
                    gameid = globalData?.game_id.toString()
                    finishTime = ""
                    calendar = formatted


                    textDate.text = formatted
                    textViewSportName.text = globalData?.sport_name_en ?: ""
                    textFirstTeamName.text = globalData?.opp_1_name_en ?: ""
                    textSecondTeamName.text = globalData?.opp_2_name_en ?: ""
                    if (globalData != null) {
                        winFirstScore.text = globalData.game_oc_list.elementAtOrNull(0)?.oc_rate.toString()
                        drawScore.text = globalData.game_oc_list.elementAtOrNull(1)?.oc_rate.toString()
                        winSecondScore.text = globalData.game_oc_list.elementAtOrNull(2)?.oc_rate.toString()
                    }

                    var y = globalData?.opp_1_icon

                    if(globalData?.opp_1_icon != null){
                        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_1_icon}.png").into(binding.imageTeamOne)
                    }

                    if(globalData?.opp_2_icon != null){
                        Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_2_icon}.png").into(binding.imageTeamSecond)
                    }
                }
            }
        }
    }

    fun randomSelectLike(){

        activity?.let {
            viewModel.sportResponse.observe(it) { spor ->

                binding.apply {

                    val selectedItemList = (0..spor.body.size).random()

                    sportViewModel.insertEvents(
                        ListModel(
                            0,
                            nameOne,
                            nameSecond,
                            nameRateOne,
                            nameRateSecond,
                            nameRateThird,
                            calendar,
                            finishTime,
                            imageUrlOne,
                            imageUrlSecond,
                            score,
                            gameid
                            )
                    )

                    var globalData = spor.body.elementAtOrNull(selectedItemList)?.events_list?.elementAtOrNull(0)

                    val date = Date((globalData?.game_start ?: 0) * 1000L)
                    val format: DateFormat = SimpleDateFormat("dd.MM")
                    format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"))
                    val formatted: String = format.format(date)

                    nameOne = globalData?.opp_1_name_en ?: ""
                    nameSecond = globalData?.opp_2_name_en ?: ""
                    nameRateOne = globalData?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString()
                    nameRateSecond = globalData?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString()
                    nameRateThird = globalData?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString()
                    finishTime = ""
                    imageUrlOne = globalData?.opp_1_icon.toString()
                    imageUrlSecond = globalData?.opp_2_icon.toString()
                    score = globalData?.score_full ?: ""
                    gameid = globalData?.game_id.toString()
                    calendar = formatted

                    textDate.text = formatted

                    textViewSportName.text = globalData?.sport_name_en ?: ""
                    textFirstTeamName.text = globalData?.opp_1_name_en ?: ""
                    textSecondTeamName.text = globalData?.opp_2_name_en ?: ""
                    if (globalData != null) {
                        winFirstScore.text = globalData.game_oc_list.elementAtOrNull(0)?.oc_rate.toString()
                        drawScore.text = globalData.game_oc_list.elementAtOrNull(1)?.oc_rate.toString()
                        winSecondScore.text = globalData.game_oc_list.elementAtOrNull(2)?.oc_rate.toString()
                    }

                    Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_1_icon}.png").into(binding.imageTeamOne)
                    Glide.with(activity!!).load("https://cdn.incub.space/v1/opp/icon/${globalData?.opp_2_icon}.png").into(binding.imageTeamSecond)

                }
            }
        }
    }

    private fun saveNote(value : String) {
        val sport = SportModel(0, value)
        sportViewModel.insertSport(sport)
    }
}