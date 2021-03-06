package com.mobile.umentoring.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.umentoring.R
import com.mobile.umentoring.adapter.recyclerView.Home.LeaderboardAdapter
import com.mobile.umentoring.adapter.recyclerView.Home.TestimoniAdapter
import com.mobile.umentoring.adapter.recyclerView.Profile.PortofolioProfileAdapter
import com.mobile.umentoring.model.DataItemProgram
import com.mobile.umentoring.model.ResponseClassLeaderboard
import com.mobile.umentoring.model.ResponseLeaderboard
import com.mobile.umentoring.viewModel.ViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_leaderboard.*
import kotlinx.android.synthetic.main.fragment_profile.*

@Suppress("UNREACHABLE_CODE")
class LeaderboardFragment : Fragment() {

    lateinit var view: ViewModel
    var id: Int? = 0

    val kelas = arrayOf("All Class","Flutter", "Kotlin", "UiDesign", "Web", "English", "Kotlin II", "Flutter II")
    val batch = arrayOf("All Batch","1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view = ViewModelProvider(this)[ViewModel::class.java]
        var getData = arguments?.getParcelable<DataItemProgram>("data")
        Log.e("data","$getData")

        attachObserveLeaderboard()

        var getId = arguments?.getInt("data")

        view.panggilApiLeaderboard()

        if (getId!=null) {
            view.panggilApiProgClassLeaderboard(getId.toString())
        }

        ivBackLeaderboard.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_leaderboardFragment2_to_homeFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_dropdown_item_1line, kelas) }
        val arrayAdapters =
            context?.let { ArrayAdapter(it, android.R.layout.simple_dropdown_item_1line, batch) }
//        spOption1.adapter = arrayAdapter
//        spOption2.adapter = arrayAdapters
//        spOption1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(context, "You selected "+kelas[position], Toast.LENGTH_LONG).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }

//        spOption2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(context, "You selected "+batch[position], Toast.LENGTH_LONG).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }
    }

    private fun attachObserveLeaderboard(){
        view.successLeaderboard().observe(viewLifecycleOwner, Observer { showSuccessLeaderboard(it) })
        view.errorLeaderboard().observe(viewLifecycleOwner, Observer { showErrorLeaderboard(it) })

        view.successProgramClassLeaderboard()
            .observe(viewLifecycleOwner, Observer { showSuccessProgClassLeaderboard(it) })
        view.errorTotalScore()
            .observe(viewLifecycleOwner, Observer { showErrorTotalScore(it) })
    }

    private fun showErrorTotalScore(it: Throwable?) {
        Toast.makeText(context, it?.message,Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessProgClassLeaderboard(it: ResponseClassLeaderboard?) {
        for(x in it?.data?.indices?:0..1){
            spOption1.text = it?.data?.get(x)?.namaProgram
            spOption2.text = it?.data?.get(x)?.partisipant?.angkatan
        }
    }

    private fun showErrorLeaderboard(it: Throwable?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessLeaderboard(it: ResponseLeaderboard?) {
        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()

        var adapter = LeaderboardAdapter(it?.data)
        rvLeaderboard.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvLeaderboard.adapter = adapter
    }


}