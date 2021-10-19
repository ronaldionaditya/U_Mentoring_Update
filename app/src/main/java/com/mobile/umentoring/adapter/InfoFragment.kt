package com.mobile.umentoring.adapter

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
import com.mobile.umentoring.adapter.recyclerView.Home.InfoAdapter
import com.mobile.umentoring.adapter.recyclerView.Home.QuestionAdapter
import com.mobile.umentoring.model.DataItemInfo
import com.mobile.umentoring.model.DataItemPretest
import com.mobile.umentoring.model.ResponseInfo
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_pretest.*

class InfoFragment : Fragment() {

    //1 deklarasi
    lateinit var view: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //2 init
        initt()

        //3 pengamatan
        pengamatan()

        //4 implementasi
        view.panggilApiInfo()

    }

    private fun pengamatan() {
        view.successInfo()
            .observe(viewLifecycleOwner, Observer { showSuccessInfo(it) })
        view.errorInfo()
            .observe(viewLifecycleOwner, Observer { showErrorInfo(it) })
    }

    private fun showErrorInfo(it: Throwable?) {
        Toast.makeText(context,it?.message, Toast.LENGTH_SHORT).show()
        Log.e("error",it?.message?:"")
    }

    private fun showSuccessInfo(it: ResponseInfo?) {
        var adapter = InfoAdapter(it?.data,object : InfoAdapter.klik{
            override fun a(data: DataItemInfo?) {
                Toast.makeText(context, data?.judul, Toast.LENGTH_SHORT).show()
            }
        })

        rvInfo.adapter = adapter
    }

    private fun initt() {
        view = ViewModelProvider(this)[ViewModel::class.java]
    }
}