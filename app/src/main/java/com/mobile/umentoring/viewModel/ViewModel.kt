package com.mobile.umentoring.viewModel


import android.widget.ProgressBar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.umentoring.model.*
import com.mobile.umentoring.repository.Repository

class ViewModel : ViewModel() {

    // Todo 2 inisiaslisasi repository
    val repository = Repository()

    // Todo membuat variabel agar bisa ditampung view
    var emailKosong = MutableLiveData<Boolean>()
    var passwordKosong = MutableLiveData<Boolean>()
    var errorLogin = MutableLiveData<Throwable>()
    var responLogin = MutableLiveData<ResponseUser>()


    //Register
    var emailKosongRegister = MutableLiveData<Boolean>()
    var passwordKosongRegister = MutableLiveData<Boolean>()
    var errorRegister = MutableLiveData<Throwable>()
    var responRegister = MutableLiveData<ResponseRegister>()

    // Todo RecyclerView
    var repo = Repository()

    //Home
    var successProg = MutableLiveData<ResponseProgram1>()
    var errorProg = MutableLiveData<Throwable>()
    var successPort = MutableLiveData<ResponsePortofolio>()
    var errorPort = MutableLiveData<Throwable>()
    var successTest = MutableLiveData<ResponseTestimoni>()
    var errorTest = MutableLiveData<Throwable>()

    // Pretest
    var successPretest = MutableLiveData<ResponseQuizPretest>()
    var errorPretest = MutableLiveData<Throwable>()

    // Posttest
    var successPosttest = MutableLiveData<ResponseQuizPosttest>()
    var errorPosttest = MutableLiveData<Throwable>()

    // Info
    var successInfo = MutableLiveData<ResponseInfo>()
    var errorInfo = MutableLiveData<Throwable>()

    // Vacancy
    var successVacancy = MutableLiveData<ResponseVacancy>()
    var errorVacancy = MutableLiveData<Throwable>()

    //Profile
    var successProfile = MutableLiveData<ResponseProfile>()
    var errorProfile = MutableLiveData<Throwable>()

    var succeessProgramProfile = MutableLiveData<ResponseProgramProfile>()
    var errorProgramProfile = MutableLiveData<Throwable>()

    var succeessPortofolioProfile = MutableLiveData<ResponsePortofolioProfile>()
    var errorPortofolioProfile = MutableLiveData<Throwable>()

    var succeessTestimoniProfile = MutableLiveData<ResponseTestimoniProfile>()
    var errorTestimoniProfile = MutableLiveData<Throwable>()

    var succeessLeaderboard = MutableLiveData<ResponseLeaderboard>()
    var errorLeaderboard = MutableLiveData<Throwable>()

    var succeessTotalScore = MutableLiveData<ResponseTotalScore>()
    var errorTotalScore = MutableLiveData<Throwable>()

    var successProgramClassLeaderboard = MutableLiveData<ResponseClassLeaderboard>()
    var errorProgramClassLeaderboard = MutableLiveData<Throwable>()

    var successQuestion = MutableLiveData<ResponseQuestionQuiz>()
    var errorQuestion = MutableLiveData<Throwable>()

    var succeessMyScore = MutableLiveData<ResponseMyScore>()
    var errorMyScore = MutableLiveData<Throwable>()

    //Todo ProgressBar
    var progressBar = MutableLiveData<Boolean>()

    fun login(
        email: String,
        password: String
    ) {
        progressBar.value = true
        if (email.isEmpty()) {
            emailKosong.value = true
            progressBar.value = false

        } else if (password.isEmpty()) {
            passwordKosong.value = true
            progressBar.value = false

        } else {
            repository.login(email, password, {
                responLogin.value = it
                progressBar.value = false
            }, {
                errorLogin.value = it
                progressBar.value = false
            })
        }
    }

    fun emailIsEmpty(): LiveData<Boolean> {
        return emailKosong
    }

    fun passwordIsEmpty(): LiveData<Boolean> {
        return passwordKosong
    }

    fun loginError(): LiveData<Throwable> {
        return errorLogin
    }

    fun loginResponse(): LiveData<ResponseUser> {
        return responLogin
    }

    //ProgressBar LiveData untuk dibawa ke Fragment
    fun progressBarLive(): LiveData<Boolean> {
        return progressBar
    }


    // Register
    fun register(
        name: String,
        email: String,
        password: String
    ) {
        progressBar.value = true
        if (email.isEmpty()) {
            emailKosongRegister.value = true
            progressBar.value = false

        } else if (password.isEmpty()) {
            passwordKosongRegister.value = true
            progressBar.value = false

        } else {
            repository.register(name, email, password, {
                responRegister.value = it
                progressBar.value = false
            }, {
                errorRegister.value = it
                progressBar.value = false
            })
        }

    }

    fun registerResponse(): LiveData<ResponseRegister> {
        return responRegister
    }

    fun registerError(): LiveData<Throwable> {
        return errorRegister
    }

    //Todo panggil repo api RecyclerView
    //Program
    fun panggilApiProgram() {
        progressBar.value = true
        repo.getApiProgram({
            successProg.value = it
            progressBar.value = false
        }, {
            errorProg.value = it
            progressBar.value = false
        })
    }

    fun successProg(): LiveData<ResponseProgram1> {
        return successProg
    }

    fun errorProg(): LiveData<Throwable> {
        return errorProg
    }

    //Portofolio
    fun panggilApiPort() {
        progressBar.value = true
        repo.getApiPortofolio({
            successPort.value = it
            progressBar.value = false
        }, {
            errorPort.value = it

        })
    }

    fun successPort(): LiveData<ResponsePortofolio> {
        return successPort
    }

    fun errorPort(): LiveData<Throwable> {
        return errorPort
    }


    //Testimoni
    fun panggilApiTest() {
        progressBar.value = true
        repo.getApiTestimoni({
            successTest.value = it
            progressBar.value = false
        }, {
            errorTest.value = it
            progressBar.value = false
        })
    }

    fun successTest(): LiveData<ResponseTestimoni> {
        return successTest
    }

    fun errorTest(): LiveData<Throwable> {
        return errorTest
    }


    //Profile User
    fun panggilApiProfile(user: String) {
        progressBar.value = true
        repo.getApiProfile(user, {
            successProfile.value = it
            progressBar.value = false
        }, {
            errorProfile.value = it
            progressBar.value = false
        })
    }

    fun successProfile(): LiveData<ResponseProfile> {
        return successProfile
    }

    fun errorProfile(): LiveData<Throwable> {
        return errorProfile
    }

    //Profile Program
    fun panggilApiProgramProfile(participant: String) {
        repo.getApiProgramProfile(participant, {
            succeessProgramProfile.value = it
        }, {
            errorProgramProfile.value = it
        })
    }

    fun succeessProgramProfile(): LiveData<ResponseProgramProfile> {
        return succeessProgramProfile
    }

    fun errorProgramProfile(): LiveData<Throwable> {
        return errorProgramProfile
    }

    //Profile Portofolio
    fun panggilApiPortofolioProfile(participantPort: String) {
        repo.getApiPortofolioProfile(participantPort, {
            succeessPortofolioProfile.value = it
        }, {
            errorPortofolioProfile.value = it
        })
    }

    fun succeessPortofolioProfile(): LiveData<ResponsePortofolioProfile> {
        return succeessPortofolioProfile
    }

    fun errorPortofolioProfile(): LiveData<Throwable> {
        return errorPortofolioProfile
    }

    //Profile Testimoni
    fun panggilApiTestimoniProfile(userTest: String) {
        repo.getApiTestimoniProfile(userTest, {
            succeessTestimoniProfile.value = it
        }, {
            errorTestimoniProfile.value = it
        })
    }

    fun successTestimoniProfile(): LiveData<ResponseTestimoniProfile> {
        return succeessTestimoniProfile
    }

    fun errorTestimoniProfile(): LiveData<Throwable> {
        return errorTestimoniProfile
    }

    //Leaderboard
    fun panggilApiLeaderboard() {
        repo.getApiLeaderboard({
            succeessLeaderboard.value = it
        }, {
            errorLeaderboard.value = it
        })
    }

    fun successLeaderboard(): LiveData<ResponseLeaderboard> {
        return succeessLeaderboard
    }

    fun errorLeaderboard(): LiveData<Throwable> {
        return errorLeaderboard
    }

    //My Score
    fun panggilApiTotalScore(participantTotal: String) {
        repo.getApiTotalScore(participantTotal, {
            succeessTotalScore.value = it
        }, {
            errorTotalScore.value = it
        })
    }

    fun successTotalScore(): LiveData<ResponseTotalScore> {
        return succeessTotalScore
    }

    fun errorTotalScore(): LiveData<Throwable> {
        return errorTotalScore
    }

    //Program Class Leaderboard
    fun panggilApiProgClassLeaderboard(programClassLeaderboard: String) {
        repo.getApiProgramClassLeaderboard(programClassLeaderboard, {
            successProgramClassLeaderboard.value = it
        }, {
            errorTotalScore.value = it
        })
    }

    fun successProgramClassLeaderboard(): LiveData<ResponseClassLeaderboard> {
        return successProgramClassLeaderboard
    }

    fun errorProgramClassLeaderboard(): LiveData<Throwable> {
        return errorTotalScore
    }

    //Question Quiz
    fun panggilApiQuestion(questionQuiz: String) {
        repo.getApiQuestion(questionQuiz, {
            successQuestion.value = it
        }, {
            errorQuestion.value = it
        })
    }

    fun successQuestion(): LiveData<ResponseQuestionQuiz> {
        return successQuestion
    }

    fun errorQuestion(): LiveData<Throwable> {
        return errorQuestion
    }


    // Pretest
    fun panggilApiPretest() {
        repo.getApiPretest({
            successPretest.value = it

        }, {
            errorPretest.value = it
        })
    }

    fun successPretest(): LiveData<ResponseQuizPretest> {
        return successPretest
    }

    fun errorPretest(): LiveData<Throwable> {
        return errorPretest
    }

    // Posttest
    fun panggilApiPosttest() {
        repo.getApiPosttest({
            successPosttest.value = it
        }, {
            errorPosttest.value = it
        })
    }

    fun successPosttest(): LiveData<ResponseQuizPosttest> {
        return successPosttest
    }

    fun errorPosttest(): LiveData<Throwable> {
        return errorPosttest
    }

    // Info
    fun panggilApiInfo() {
        repo.getApiInfo({
            successInfo.value = it

        }, {
            errorInfo.value = it
        })
    }

    fun successInfo(): LiveData<ResponseInfo> {
        return successInfo
    }

    fun errorInfo(): LiveData<Throwable> {
        return errorInfo
    }

    // Vacancy
    fun panggilApiVacancy() {
        repo.getApiVacancy({
            successVacancy.value = it
        }, {
            errorVacancy.value = it
        })
    }

    fun successVacancy(): LiveData<ResponseVacancy> {
        return successVacancy
    }

    fun errorVacancy(): LiveData<Throwable> {
        return errorVacancy
    }


//    //My Score
//    fun panggilApiMyScore(participantMyScore : String){
//        repo.getApiMyScore(participantMyScore,{
//            succeessMyScore.value = it
//        },{
//            errorMyScore.value = it
//        })
//    }
//
//    fun successMyScore(): LiveData<ResponseMyScore>{
//        return succeessMyScore
//    }
//
//    fun errorMyScore():LiveData<Throwable>{
//        return errorMyScore
//    }


}