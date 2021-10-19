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
import com.mobile.umentoring.model.DataItemInfo
import com.mobile.umentoring.model.DataItemPretest

class InfoAdapter(
    val dataTest: List<DataItemInfo?>?,
    var dataRV: klik
) : RecyclerView.Adapter<InfoAdapter.InfoHolder>() {
    class InfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.ivInfo)
        val textTitle = itemView.findViewById<TextView>(R.id.tvInfo)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_info, parent, false)
        val holder = InfoHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return dataTest?.size ?: 0
    }

    override fun onBindViewHolder(holder: InfoHolder, position: Int) {
        //Dengan url constants
        var constants: Constants? = null
        constants = Constants()
        //Load gambar dengan glide
        Glide.with(holder.itemView.context)
            .load(constants.BASEURLPhpGambar + dataTest?.get(position)?.gambarInformasi)
            .into(holder.img)

        holder.textTitle.text = dataTest?.get(position)?.judul

        //holder untuk klik pada recyclerview
        holder.itemView.setOnClickListener {
            dataRV.a(dataTest?.get(position))
        }
    }

    interface klik {
        fun a(data: DataItemInfo?)
    }


}