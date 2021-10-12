package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.cons.Constants
import com.mobile.umentoring.model.DataItemProgram


class ProgramAdapter(val data: List<DataItemProgram?>?,var onClick:onCLickListener) :
    RecyclerView.Adapter<ProgramAdapter.ProgramHolder>() {
    class ProgramHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.ivImageClass)
        val textTitle = itemView.findViewById<TextView>(R.id.tvTextTitle)
        val textSub = itemView.findViewById<TextView>(R.id.tvTextSub)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_leaderboard, parent, false)
        val holder = ProgramHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProgramHolder, position: Int) {
        //Dengan url constants
        var constants: Constants? = null
        constants = Constants()
        //Load gambar dengan glide
        Glide.with(holder.itemView.context)
            .load(constants.URL_Program + data?.get(position)?.programImage)
            .into(holder.img)

        holder.textTitle.text = data?.get(position)?.namaProgram
        holder.textSub.text = data?.get(position)?.id.toString()

        holder.itemView.setOnClickListener {
            onClick.details(data?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    interface onCLickListener{
        fun details(item: DataItemProgram?)
    }


//    private lateinit var context : Context
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        context = parent.context
//        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_home_leaderboard,parent,false))
//
//    //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_leaderboard,parent,false)
//        //return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val data= dataList[position]
//
//        val imageClassView = holder.itemView.ivImageClass
//        val textTitleView = holder.itemView.tvTextTitle
//        val textSubView = holder.itemView.tvTextSub
//
//        textTitleView.text = toString()
//        textSubView.text = toString()
//
//        Picasso.get()
//            .load(data.image)
//            .into(imageClassView)
//
//    }
//
//    override fun getItemCount(): Int {
//        return dataList?.size ?: 0
//    }

}