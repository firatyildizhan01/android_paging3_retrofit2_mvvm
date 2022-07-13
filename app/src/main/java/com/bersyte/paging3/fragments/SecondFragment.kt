package com.bersyte.paging3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bersyte.paging3.R
import com.bersyte.paging3.adapter.SportAdapter
import com.bersyte.paging3.databinding.FragmentFirstBinding
import com.bersyte.paging3.databinding.FragmentSecondBinding
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.viewmodel.CharacterViewModel
import com.bersyte.paging3.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Collections.list

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private lateinit var sportAdapter: SportAdapter
    private val viewModel: CharacterViewModel by viewModels()
    private val sportViewModel: SportViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.findViewById<View>(R.id.leftView)!!.visibility = View.INVISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {

        sportAdapter = SportAdapter()

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportAdapter
        }

//        sportViewModel.allSport.observe(requireActivity()) { listTodo ->
//
//            viewModel.sportResponse.observe(requireActivity()) { sporList ->
//
//                for(i in listTodo){
//
//                     var o = sporList.body.mapNotNull {it.events_list.filter { i.sportTitle in it.game_id.toString()}}.filter {it.size == 1}.elementAtOrNull(0)
//
//                    var globalSecond = o?.elementAtOrNull(0)
//
//                    var amount = 0
//                    sportViewModel.allEvents.observe(requireActivity()) { events ->
//
//                        if (events.size == 0){
//                            sportViewModel.insertEvents(ListModel(
//                                0,
//                                globalSecond?.opp_1_name_en ?: "",
//                                globalSecond?.opp_2_name_en ?: "",
//                                globalSecond?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString(),
//                                globalSecond?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString(),
//                                globalSecond?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString(),
//                                globalSecond?.finale.toString()))
//                        }
//
//                        for(m in events){
//                            if(m.nameOne != (globalSecond?.opp_1_name_en ?: "")
//                                && m.rateOne != globalSecond?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString()
//                                && m.rateTwo != globalSecond?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString()
//                                && m.rateThird != globalSecond?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString()
//                            ){
//                                amount = 1
//                            }
//                        }
//                    }
//
//                    if (amount == 1){
//                        sportViewModel.insertEvents(ListModel(
//                            0,
//                            globalSecond?.opp_1_name_en ?: "",
//                            globalSecond?.opp_2_name_en ?: "",
//                            globalSecond?.game_oc_list?.elementAtOrNull(0)?.oc_rate.toString(),
//                            globalSecond?.game_oc_list?.elementAtOrNull(1)?.oc_rate.toString(),
//                            globalSecond?.game_oc_list?.elementAtOrNull(2)?.oc_rate.toString(),
//                            globalSecond?.finale.toString()))
//                        amount = 0
//                    }
//                }
//            }
//        }
        sportViewModel.allEvents.observe(requireActivity()) { events ->
            sportAdapter.sportList = events
        }
    }
}