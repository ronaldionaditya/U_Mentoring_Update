package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.umentoring.R
import com.mobile.umentoring.model.DataItemPosttest
import com.mobile.umentoring.model.DataItemPretest

class QuestionPosttestAdapter(
    val dataTest: List<DataItemPosttest?>?,
    var dataRV: klik
) : RecyclerView.Adapter<QuestionPosttestAdapter.QuestionPosttestHolder>() {
    class QuestionPosttestHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val soal = itemView.findViewById<TextView>(R.id.tvQuestionPost)
        val jawabA = itemView.findViewById<TextView>(R.id.rbAnswerAPost)
        val jawabB = itemView.findViewById<TextView>(R.id.rbAnswerBPost)
        val jawabC = itemView.findViewById<TextView>(R.id.rbAnswerCPost)
        val jawabD = itemView.findViewById<TextView>(R.id.rbAnswerDPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionPosttestHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question_posttest, parent, false)
        val holder = QuestionPosttestAdapter.QuestionPosttestHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return dataTest?.size ?: 0
    }

    override fun onBindViewHolder(holder: QuestionPosttestHolder, position: Int) {
        holder.soal.text = dataTest?.get(position)?.questionText
        holder.jawabA.text = dataTest?.get(position)?.answerA
        holder.jawabB.text = dataTest?.get(position)?.answerB
        holder.jawabC.text = dataTest?.get(position)?.answerC
        holder.jawabD.text = dataTest?.get(position)?.answerD

        //holder untuk klik pada recyclerview
        holder.itemView.setOnClickListener {
            dataRV.a(dataTest?.get(position))
        }
    }

    interface klik {
        fun a(data: DataItemPosttest?)
    }


}