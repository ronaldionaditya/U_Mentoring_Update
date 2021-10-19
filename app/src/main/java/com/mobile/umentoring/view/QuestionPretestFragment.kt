//package com.mobile.umentoring.view
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.Navigation
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.mobile.umentoring.R
//import com.mobile.umentoring.adapter.recyclerView.Home.ProgramAdapter
//import com.mobile.umentoring.adapter.recyclerView.Home.QuestionAdapter
//import com.mobile.umentoring.model.DataItemProgram
//import com.mobile.umentoring.model.DataItemQuestion
//import com.mobile.umentoring.model.ResponseQuestionQuiz
//import com.mobile.umentoring.viewModel.ViewModel
//import kotlinx.android.synthetic.main.fragment_profile.*
//import kotlinx.android.synthetic.main.fragment_question_quiz.*
//import kotlinx.android.synthetic.main.fragment_score.*
//
//
//class QuestionPretestFragment : Fragment() {
//
//    lateinit var view: ViewModel
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_question_quiz, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        view = ViewModelProvider(this)[ViewModel::class.java]
//        attachObserveQuestion()
//
//    }
//
//    private fun attachObserveQuestion() {
//        view.successQuestion()
//            .observe(viewLifecycleOwner, Observer { showSuccessQuestion(it) })
//        view.errorQuestion()
//            .observe(viewLifecycleOwner, Observer { showErrorQuestion(it) })
//    }
//
//    private fun showErrorQuestion(it: Throwable?) {
//        Toast.makeText(context, it?.message, Toast.LENGTH_SHORT).show()
//    }
//
//    private fun showSuccessQuestion(it: ResponseQuestionQuiz?) {
////        Toast.makeText(context, "Success Question", Toast.LENGTH_SHORT).show()
//
////        var adapter = QuestionAdapter(it?.data, object : QuestionAdapter.klik {
////            override fun a(item: DataItemQuestion?) {
////                var bundle = Bundle()
////                bundle.putInt("data", item?.id ?: 0)
////                Navigation.findNavController(requireView())
////                    .navigate(R.id.action_quizFragment_to_questionQuizFragment, bundle)
////            }
////        })
////        rvQuestion.layoutManager =
////            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
////        rvQuestion.adapter = adapter
//
//    }
//}