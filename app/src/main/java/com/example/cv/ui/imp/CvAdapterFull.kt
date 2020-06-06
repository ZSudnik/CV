package com.example.cv.ui.imp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cv.R
import com.example.cv.db.entity.ExperienceEnt


class CvAdapterFull(val context: Context):
                    RecyclerView.Adapter<CvAdapterFull.MyViewHolder>() {

    private val dataSet = mutableListOf<ExperienceEnt>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val oneRecord = dataSet[position] //val defList = dataList[position]

        holder.bind(oneRecord, this, position)
    }


    fun addList(resultArr: List<ExperienceEnt>) {
        dataSet.addAll(resultArr)
    }


    fun notifyChangeCreateLayout() {
        notifyDataSetChanged()
    }

    fun notifyChange() {
        notifyDataSetChanged()
    }

    class MyViewHolder
    private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val date_end: TextView = itemView.findViewById(R.id.date_end)
        val date_start: TextView = itemView.findViewById(R.id.date_start)
        val position_txt: TextView = itemView.findViewById(R.id.txt_position)
        val descriptor: TextView = itemView.findViewById(R.id.txt_description)

        fun bind(item: ExperienceEnt, adapter: CvAdapterFull, position: Int) {
            with(itemView) {
                date_start.text = item.mDateStart.toString()
                date_end.text = item.mDateEnd.toString()
                position_txt.text = item.mPosition
                descriptor.text = item.mDescription
            }
        }


        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemView = layoutInflater
                    .inflate(R.layout.one_experience_cv, parent, false)
                return MyViewHolder(itemView)
            }
        }
    }


}