package com.mobile.umentoring.repository

import com.mobile.umentoring.model.*
import com.mobile.umentoring.network.ConfigNetwork
import com.mobile.umentoring.network.ConfigNetworkLaravel
import com.mobile.umentoring.network.ConfigNetworkPhp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun login(
        email: String,
        password: String,
        responseHandler: (ResponseUser) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun register(
        name: String,
        email: String,
        password: String,
        responseHandler: (ResponseRegister) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetworkLaravel.getRetrofit().register(name, email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }


    fun getApiProgram(
        responseSuccess: (ResponseProgram1) -> Unit,
        responseError: (Throwable) -> Unit
    ) {

        ConfigNetworkLaravel.getRetrofit().getApiProgram().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseSuccess(response)
            }, { e ->
                responseError(e)
            })
    }

    fun getApiPortofolio(
        responseSuccess: (ResponsePortofolio) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiPortofolio().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

    fun getApiTestimoni(
        responseSuccess: (ResponseTestimoni) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiTestimoni().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

    fun getApiProfile(
        user: String,
        responseSuccess: (ResponseProfile) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetwork.getRetrofit().getApiProfile(user).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            }, {
                responseError(it)
            })
    }

    fun getApiProgramProfile(
        participant: String,
        responseSuccess: (ResponseProgramProfile) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetwork.getRetrofit().getApiProgramProfile(participant).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiPortofolioProfile(
        participantPort:String,
        responseSuccess: (ResponsePortofolioProfile) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetwork.getRetrofit().getApiPortofolioProfile(participantPort).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiTestimoniProfile(
        userTest : String,
        responseSuccess: (ResponseTestimoniProfile) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetwork.getRetrofit().getApiTestimoniProfile(userTest).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    //Leaderboard
    fun getApiLeaderboard(
        responseSuccess: (ResponseLeaderboard) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetwork.getRetrofit().getApiLeaderboard().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }
    //Total Score
    fun getApiTotalScore(
        participantTotal : String,
        responseSuccess: (ResponseTotalScore) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetwork.getRetrofit().getApiTotalScore(participantTotal).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiProgramClassLeaderboard(
        programClassLeaderboard : String,
        responseSuccess: (ResponseClassLeaderboard) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetworkLaravel.getRetrofit().getApiProgramClassLeaderboard(programClassLeaderboard).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiQuestion(
        questionQuiz : String,
        responseSuccess:(ResponseQuestionQuiz) -> Unit,
        responseError: (Throwable) -> Unit
    ) {
        ConfigNetworkLaravel.getRetrofit().getApiQuestion(questionQuiz).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiPretest(
        responseSuccess:(ResponseQuizPretest) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetworkPhp.getRetrofit().getApiPretest().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiPosttest(
        responseSuccess:(ResponseQuizPosttest) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetworkPhp.getRetrofit().getApiPosttest().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiInfo(
        responseSuccess:(ResponseInfo) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetworkPhp.getRetrofit().getApiInfo().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }

    fun getApiVacancy(
        responseSuccess:(ResponseVacancy) -> Unit,
        responseError: (Throwable) -> Unit
    ){
        ConfigNetworkPhp.getRetrofit().getApiVacancy().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseSuccess(it)
            },{
                responseError(it)
            })
    }


//    fun getApiMyScore(
//        participantMyScore : String,
//        responseSuccess: (ResponseMyScore) -> Unit,
//        responseError: (Throwable) -> Unit
//    ){
//        ConfigNetwork.getRetrofit().getApiMyScore(participantMyScore).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                responseSuccess(it)
//            },{
//                responseError(it)
//            })
//    }

}