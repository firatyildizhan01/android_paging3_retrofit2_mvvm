package com.sport.sportlike.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sport.sportlike.R
import com.sport.sportlike.adapter.SportAdapter
import com.sport.sportlike.databinding.FragmentSecondBinding
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.utils.IsOnline
import com.sport.sportlike.viewmodel.CharacterViewModel
import com.sport.sportlike.viewmodel.SportViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    var listNew = listOf<ListModel>()
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
        if(activity?.let { IsOnline().isOnline(it) } == true){setupRecyclerView()}


        return binding.root
    }

    private fun setupRecyclerView() {

        sportViewModel.allEvents.observe(requireActivity()) { events ->
            for(i in events) {
                viewModel.sportResponse.observe(requireActivity()) { sporList ->

                    var o = sporList.body.mapNotNull {it.events_list.filter { i.gameid in it.game_id.toString()}}.filter {it.size == 1}.elementAtOrNull(0)

                    if(o?.elementAtOrNull(0)?.finale == false){
                        sportViewModel.updateEvents(o?.elementAtOrNull(0)?.game_id ?: 0,o?.elementAtOrNull(0)?.score_full.toString())
                    }

                }
            }
        }

        sportAdapter = SportAdapter()

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sportAdapter

            sportViewModel.allEvents.observe(requireActivity()) { events ->
                sportAdapter.sportList = events
                listNew = events
            }

            val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
                ItemTouchHelper.SimpleCallback(
                    0,
                    ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN or ItemTouchHelper.UP
                ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    Toast.makeText(activity, "on Move", Toast.LENGTH_SHORT).show()
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                    Toast.makeText(activity, "Deleted", Toast.LENGTH_SHORT).show()
                    //Remove swiped item from list and notify the RecyclerView
                    val position = viewHolder.adapterPosition
                    var k = sportAdapter.sportList[position]
                    sportViewModel.deleteEvents(k)
                    sportAdapter.notifyDataSetChanged()
                }
            }

            val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
            itemTouchHelper.attachToRecyclerView(  binding.recyclerview)

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

    }
}