package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemPortofolio

class PortofolioAdapter(
    val data: List<DataItemPortofolio?>?,
    val klik: portofolioVideo
) :
    RecyclerView.Adapter<PortofolioAdapter.PortofolioHolder>() {
    class PortofolioHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.ivPortImg)
        val textNama = itemView.findViewById<TextView>(R.id.tvNamaPort)
        val textBatch = itemView.findViewById<TextView>(R.id.tvBatchPort)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortofolioHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_portfolio, parent, false)
        val holder = PortofolioHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: PortofolioHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.participant?.image)
            .into(holder.img)

        holder.textNama.text = data?.get(position)?.participant?.name
        holder.textBatch.text = data?.get(position)?.participant?.angkatan
        holder.itemView.setOnClickListener {
            klik.detail(data?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    interface portofolioVideo{
        fun detail (item: DataItemPortofolio?)
    }
}