package com.mobile.umentoring.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mobile.umentoring.R
import com.mobile.umentoring.model.ResponseRegister
import com.mobile.umentoring.network.ConfigApi
import com.mobile.umentoring.network.ConfigNetwork
import com.mobile.umentoring.network.ConfigNetwork.Companion.getRetrofit
import com.mobile.umentoring.network.ConfigNetworkLaravel.Companion.getRetrofit
import kotlinx.android.synthetic.main.fragment_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.ivBackRegis -> activity?.onBackPressed()
//            R.id.btnRegister -> {
//                registrasi(
//                    etNameRegister.text.toString(),
//                    etEmailRegister.text.toString(),
//                    etPasswordRegister.text.toString(),
//                    etConfirmPassword.text.toString()
//                )
//            }
//        }
//    }

//    private fun registrasi(username: String, email: String, password: String, passKonf: String) {
//        if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passKonf.isNotEmpty()) {
//            if (password != passKonf) {
//                etConfirmPassword.error = "Password tidak sama"
//            } else {
//                val input = ConfigNetwork.getRetrofit()
//                    .register(username ?: "", email ?: "", password ?: "")
//                input.enqueue(object : Callback<ResponseRegister> {
//
//                    override fun onResponse(
//                        call: Call<ResponseRegister>,
//                        response: Response<ResponseRegister>
//                    ) {
//                        Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
//                        //startActivity(Intent(context, MainActivity::class.java))
//                        navController.navigate(R.id.action_registerFragment_to_loginFragment)
//                    }
//
//                    override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
//                        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
//                    }
//                })
//            }
//        } else {
//            if (username.isEmpty()) {
//                etNameRegister.error = "Username harus di isi"
//            }
//
//            if (email.isEmpty()) {
//                etEmailRegister.error = "Email harus di isi"
//            }
//
//            if (password.isEmpty()) {
//                etPasswordRegister.error = "Password harus di isi"
//            }
//
//            if (passKonf.isEmpty()) {
//                etConfirmPassword.error = "Konfirmasi Password harus di isi"
//            }
//        }
//    }
}

