package com.example.mytestapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestapplication.R
import com.example.mytestapplication.model.DataRandom
import kotlinx.android.synthetic.main.item_random_list.view.*

class MainAdapter(private var list: List<DataRandom>, val listener: Listener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_random_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainAdapter.ViewHolder).bind(list.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: DataRandom) {

            itemView.txtId.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.fade_transition_animation)
            itemView.actionContainerId.animation =
                AnimationUtils.loadAnimation(itemView.context, R.anim.fade_transition_animation)
            itemView.txtId.text = position.id.toString()
            itemView.txtTypeId.text = position.type
            itemView.txtSetupId.text = position.setup
            itemView.txtPunchlineId.text = position.punchline
            itemView.tag = position
            itemView.setOnClickListener { v ->
                val position = v.tag as DataRandom
                listener.setOnItemClick(position)

            }

        }
    }

    interface Listener {
        fun setOnItemClick(position: DataRandom)
    }
}