package com.sport.sportlike.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sport.sportlike.R
import com.sport.sportlike.databinding.CardListBinding
import com.sport.sportlike.fragments.SecondFragmentDirections
import com.sport.sportlike.model.ListModel

class SportAdapter : RecyclerView.Adapter<SportAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(val binding: CardListBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<ListModel>() {

        override fun areItemsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ListModel, newItem: ListModel): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, differCallback)
    var sportList: List<ListModel>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {

        return ToDoViewHolder(
            CardListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false

            )
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentToDo = sportList[position]

        holder.binding.apply {
            currentToDo
            firstTeamExp.text = currentToDo.nameOne
            secondTeamExp.text = currentToDo.nameSecond
            firstTeamRateText.text = currentToDo.rateOne
            secondTeamRateText.text = currentToDo.rateThird
            textCalendar.text = currentToDo.calendar

            cardSport.setOnClickListener {
                Navigation.findNavController(it).navigate(SecondFragmentDirections.actionSecondFragmentToDetailFragment2(currentToDo))
            }
        }
    }

    override fun getItemCount() = sportList.size

    private var onItemClickListenerString: ((String) -> Unit)? = null

    fun setOnItemClickListenerString(listenerString: (String) -> Unit) {
        onItemClickListenerString = listenerString
    }
}