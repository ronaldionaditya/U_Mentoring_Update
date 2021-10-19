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
import com.mobile.umentoring.adapter.recyclerView.Home.QuestionAdapter
import com.mobile.umentoring.adapter.recyclerView.Home.VacancyAdapter
import com.mobile.umentoring.model.DataItemPretest
import com.mobile.umentoring.model.DataItemVacancy
import com.mobile.umentoring.model.ResponseVacancy
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.android.synthetic.main.fragment_vacancy_list.*

class VacancyListFragment : Fragment() {

    //1 deklarasi
    lateinit var view: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vacancy_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //2 init
        initt()

        //3 pengamatan
        pengamatan()

        //4 implementasi
        view.panggilApiVacancy()

    }

    private fun pengamatan() {
        view.successVacancy()
            .observe(viewLifecycleOwner, Observer { showSuccessVacancy(it) })
        view.errorVacancy()
            .observe(viewLifecycleOwner, Observer { showErrorVacancy(it) })
    }

    private fun showErrorVacancy(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
        Log.e("error", it?.message ?: "")
    }

    private fun showSuccessVacancy(it: ResponseVacancy?) {
        var adapter = VacancyAdapter(it?.data, object : VacancyAdapter.klik {
            override fun a(data: DataItemVacancy?) {
                Toast.makeText(context, data?.judul, Toast.LENGTH_SHORT).show()
            }
        })
        rvVacancy.adapter = adapter
    }

    private fun initt() {
        view = ViewModelProvider(this)[ViewModel::class.java]
    }
}