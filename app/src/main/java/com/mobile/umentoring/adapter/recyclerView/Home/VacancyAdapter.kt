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
import com.mobile.umentoring.model.DataItemVacancy

class VacancyAdapter(
    val dataTest: List<DataItemVacancy?>?,
    var dataRV: VacancyAdapter.klik
) : RecyclerView.Adapter<VacancyAdapter.VacancyHolder>() {
    class VacancyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.ivVacancy)
        val textTitle = itemView.findViewById<TextView>(R.id.tvVacancy)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vacancy, parent, false)
        val holder = VacancyAdapter.VacancyHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return dataTest?.size ?: 0
    }

    override fun onBindViewHolder(holder: VacancyHolder, position: Int) {
        //Dengan url constants
        var constants: Constants? = null
        constants = Constants()
        //Load gambar dengan glide
        Glide.with(holder.itemView.context)
            .load(constants.BASEURLPhp + dataTest?.get(position)?.gambarVacancy)
            .into(holder.img)

        holder.textTitle.text = dataTest?.get(position)?.judul

        //holder untuk klik pada recyclerview
        holder.itemView.setOnClickListener {
            dataRV.a(dataTest?.get(position))
        }

    }

    interface klik {
        fun a(data: DataItemVacancy?)
    }
}