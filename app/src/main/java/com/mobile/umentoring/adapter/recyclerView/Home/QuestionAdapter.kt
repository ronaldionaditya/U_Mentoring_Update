package com.mobile.umentoring.adapter.recyclerView.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.umentoring.R
import com.mobile.umentoring.model.*

class QuestionAdapter(
    val dataTest: List<DataItemPretest?>?,
    var dataRV: klik
) : RecyclerView.Adapter<QuestionAdapter.QuestionHolder>() {
    class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val soal = itemView.findViewById<TextView>(R.id.tvQuestion)
        val jawabA = itemView.findViewById<RadioButton>(R.id.rbAnswerA)
        val jawabB = itemView.findViewById<RadioButton>(R.id.rbAnswerB)
        val jawabC = itemView.findViewById<RadioButton>(R.id.rbAnswerC)
        val jawabD = itemView.findViewById<RadioButton>(R.id.rbAnswerD)
        val pilih = itemView.findViewById<Button>(R.id.btnPilih)
        val answer = itemView.findViewById<RadioGroup>(R.id.rbAnswer)
        val txtJawaban = itemView.findViewById<TextView>(R.id.txtJawaban)

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
        holder.pilih.setOnClickListener {
            if (holder.jawabA.isChecked){
                dataRV.pilih("A",holder.txtJawaban,dataTest?.get(position))
            }else if (holder.jawabB.isChecked){
                dataRV.pilih("B",holder.txtJawaban,dataTest?.get(position))
            }else if (holder.jawabC.isChecked){
                dataRV.pilih("C",holder.txtJawaban,dataTest?.get(position))
            }else if (holder.jawabD.isChecked){
                dataRV.pilih("D",holder.txtJawaban,dataTest?.get(position))
            }
        }

    }

    interface klik {
        fun pilih(
            data: String?,
            txtJawaban: TextView,
            get: DataItemPretest?
        )
    }
}