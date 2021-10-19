package com.mobile.umentoring.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Home.QuestionAdapter
import com.mobile.umentoring.model.*
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_pretest.*

class PretestFragment : Fragment() {

    private var totalSalah: Int=0
    private var totalBenar: Int=0
    private var benar = arrayListOf<Int>()
    private var salah = arrayListOf<Int>()

    //1 deklarasi
    lateinit var view: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pretest, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //2 init
        initt()

        //3 pengamatan
        pengamatan()

        //4 implementasi
        view.panggilApiPretest()

    }

    private fun pengamatan() {
        view.successPretest()
            .observe(viewLifecycleOwner, Observer { showSuccessPretest(it) })
        view.errorPretest()
            .observe(viewLifecycleOwner, Observer { showErrorPretest(it) })

    }

    private fun showErrorPretest(it: Throwable?) {
        Toast.makeText(context,it?.message, Toast.LENGTH_SHORT).show()
        Log.e("error",it?.message?:"")
    }

    private fun showSuccessPretest(it: ResponseQuizPretest?) {
        var adapter = QuestionAdapter(it?.data,object : QuestionAdapter.klik{

            override fun pilih(
                data: String?,
                txtJawaban: TextView,
                get: DataItemPretest?
            ) {
                if (data==get?.correctAnswer){
                    benar.add(1)
                    for (x in benar){
                        totalBenar = totalBenar.plus(x)
                    }
                    Toast.makeText(context, "Benar", Toast.LENGTH_SHORT).show()
                }else{
                    salah.add(1)
                    for (x in salah){
                        totalSalah = totalSalah.plus(x)
                    }
                    Toast.makeText(context, "Salah", Toast.LENGTH_SHORT).show()
                }

                count.text = "Benar :$totalBenar dan Salah: $totalSalah"
            }
        })
        rvQuestion.adapter = adapter
    }

    private fun initt() {
        view = ViewModelProvider(this)[ViewModel::class.java]
    }


}