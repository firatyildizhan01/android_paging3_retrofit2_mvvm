package com.bersyte.paging3.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bersyte.paging3.R
import com.bersyte.paging3.databinding.CardListBinding
import com.bersyte.paging3.db.SportDao
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.model.SportModel
import com.bersyte.paging3.repository.SportRepository
import com.bersyte.paging3.viewmodel.SportViewModel

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
            firstTeamExp.text = currentToDo.nameOne
            secondTeamExp.text = currentToDo.nameSecond
            firstTeamRateText.text = currentToDo.rateOne
            secondTeamRateText.text = currentToDo.rateThird
            textCalendar.text = currentToDo.calendar

            cardSport.setOnClickListener {
                Navigation.findNavController(it).navigate(Secin)

            }
        }
    }

    override fun getItemCount() = sportList.size

}