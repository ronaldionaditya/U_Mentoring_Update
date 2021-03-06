package com.mobile.umentoring.adapter.recyclerView.Profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemProgramProfile

class ProgramProfileAdapter(val data: List<DataItemProgramProfile?>?,
    var dataRV : klik    ) :
    RecyclerView.Adapter<ProgramProfileAdapter.ProgramProfileHolder>() {
    class ProgramProfileHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageProgram = itemView.findViewById<ImageView>(R.id.ivImageProgram)
        var namaProgram = itemView.findViewById<TextView>(R.id.tvNamaProgram)
        var angkatanProgram = itemView.findViewById<TextView>(R.id.tvAngkatan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramProfileHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_class, parent, false)
        val holder = ProgramProfileHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProgramProfileHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.program?.programImage)
            .into(holder.imageProgram)
        holder.namaProgram.text = data?.get(position)?.program?.namaProgram
        holder.angkatanProgram.text = data?.get(position)?.angkatan

        //holder untuk klik pada recyclerview
        holder.itemView.setOnClickListener{
            dataRV.a(data?.get(position))
        }

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    //TODO MENAMBAHKAN ONCLIK PADA RECYCLERVIEW
    //ditambah bundle pada fragmentnya
    interface klik{
        fun a(data : DataItemProgramProfile?)

    }

}