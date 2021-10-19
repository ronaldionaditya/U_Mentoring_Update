package com.mobile.umentoring.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Home.QuestionAdapter
import com.mobile.umentoring.adapter.recyclerView.Home.QuestionPosttestAdapter
import com.mobile.umentoring.model.DataItemPosttest
import com.mobile.umentoring.model.DataItemPretest
import com.mobile.umentoring.model.ResponseQuizPosttest
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_posttest.*
import kotlinx.android.synthetic.main.fragment_pretest.*

class PosttestFragment : Fragment() {

    //1 deklarasi
    lateinit var view: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posttest, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //2 init
        initt()

        //3 pengamatan
        pengamatan()

        //4 implementasi
        view.panggilApiPosttest()

    }

    private fun pengamatan() {
        view.successPosttest()
            .observe(viewLifecycleOwner, Observer { showSuccessPosttest(it) })
        view.errorPosttest()
            .observe(viewLifecycleOwner, Observer { showErrorPosttest(it) })
    }

    private fun showErrorPosttest(it: Throwable?) {
        Toast.makeText(context,it?.message, Toast.LENGTH_SHORT).show()
        Log.e("error",it?.message?:"")
    }

    private fun showSuccessPosttest(it: ResponseQuizPosttest?) {
        var adapter = QuestionPosttestAdapter(it?.data,object : QuestionPosttestAdapter.klik{
            override fun a(data: DataItemPosttest?) {
                Toast.makeText(context, data?.questionText, Toast.LENGTH_SHORT).show()
            }

        })
        rvQuestionPosttest.adapter = adapter
    }

    private fun initt() {
        view = ViewModelProvider(this)[ViewModel::class.java]
    }

}