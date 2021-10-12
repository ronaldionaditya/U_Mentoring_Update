package com.mobile.umentoring.DBHelper

import android.content.Context
import com.mobile.umentoring.model.CategoryModel
import com.mobile.umentoring.model.QuestionModul
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

//class DBHelper(context: Context) : SQLiteAssetHelper(context, DB_NAME, null, DB_VER) {
//    companion object {
//        private var instance: DBHelper? = null
//
//        private var DB_NAME = "EDMTQuiz2019.db"
//        private var DB_VER = 1
//
//        @Synchronized
//        fun getInstance(context: Context): DBHelper {
//            if (instance == null)
//                instance = DBHelper(context)
//            return instance!!
//        }
//    }
//
//    //Get All Category
//    val allCategories: MutableList<CategoryModel>
//        get() {
//            val db = instance!!.writableDatabase
//
//            val cursor = db.rawQuery("SELECT * FROM CategoryModel", null)
//            val categories = ArrayList<CategoryModel>()
//            if (cursor.moveToFirst()) {
//                while (!cursor.isAfterLast) {
//                    val category = CategoryModel(
//                        cursor.getInt(cursor.getColumnIndex("ID")),
//                        cursor.getString(cursor.getColumnIndex("Name")),
//                        cursor.getString(cursor.getColumnIndex("Image"))
//                    )
//                    categories.add(category)
//                    cursor.moveToNext()
//                }
//            }
//            cursor.close()
//            db.close()
//
//            return categories
//
//            //TODO LANJUT VIDEO EDMT DEV
//        }
//
//    //Get All Question Category
//
//    fun getQuestionByCategory(categoryId: Int): MutableList<QuestionModul> {
//        val db = instance!!.writableDatabase
//
//        val cursor = db.rawQuery(
//            "SELECT * FROM QuestionModel WHERE categoryId=$categoryId ORDER BY RANDOM() LIMIT 30",
//            null
//        )
//        val questionList = ArrayList<CategoryModel>()
//        if (cursor.moveToFirst()) {
//            while (!cursor.isAfterLast) {
//                val question = QuestionModul(
//                    cursor.getInt(cursor.getColumnIndex("ID")),
//                    cursor.getString(cursor.getColumnIndex("QuestionText")),
//                    cursor.getString(cursor.getColumnIndex("QuestionImage")),
//                    cursor.getString(cursor.getColumnIndex("AnswerA")),
//                    cursor.getString(cursor.getColumnIndex("AnswerB")),
//                    cursor.getString(cursor.getColumnIndex("AnswerC")),
//                    cursor.getString(cursor.getColumnIndex("AnswerD")),
//                    cursor.getString(cursor.getColumnIndex("CorrectAnswer")),
//                    if cursor.getString(cursor.getColumnIndex("IsImageQuestion")) == 0
//                ) java . lang . Boolean . FALSE else java . lang . Boolean . TRUE,
//
//                )
//            }
//        }
//    }
//
//}