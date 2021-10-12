package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Profile.ProgramProfileAdapter
import com.mobile.umentoring.model.DataItemProgramProfile
import com.mobile.umentoring.model.DataItemQuestion
import com.mobile.umentoring.model.DataItemTestimoni

class QuestionAdapter(
    val dataTest: List<DataItemQuestion?>?,
    var dataRV: QuestionAdapter.klik) :
    RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {
    class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val soal = itemView.findViewById<TextView>(R.id.tvQuestion)
        val jawabA = itemView.findViewById<TextView>(R.id.rbAnswerA)
        val jawabB = itemView.findViewById<TextView>(R.id.rbAnswerB)
        val jawabC = itemView.findViewById<TextView>(R.id.rbAnswerC)
        val jawabD = itemView.findViewById<TextView>(R.id.rbAnswerD)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        val holder = QuestionAdapter.QuestionHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return dataTest?.size ?: 0
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.soal.text = dataTest?.get(position)?.questionText
        holder.jawabA.text = dataTest?.get(position)?.answerA
        holder.jawabB.text = dataTest?.get(position)?.answerB
        holder.jawabC.text = dataTest?.get(position)?.answerC
        holder.jawabD.text = dataTest?.get(position)?.answerD

        //holder untuk klik pada recyclerview
        holder.itemView.setOnClickListener{
            dataRV.a(dataTest?.get(position))
        }
    }
    interface klik {
        fun a(data : DataItemQuestion?)
    }
}