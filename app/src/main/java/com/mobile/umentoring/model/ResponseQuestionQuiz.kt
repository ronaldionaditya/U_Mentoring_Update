package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponseQuestionQuiz(

	@field:SerializedName("data")
	val data: List<DataItemQuestion?>? = null,

	@field:SerializedName("meta")
	val meta: MetaQuestion? = null
)

data class MetaQuestion(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItemQuestion(

	@field:SerializedName("isImageQuestion")
	val isImageQuestion: Int? = null,

	@field:SerializedName("questionImage")
	val questionImage: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("questionText")
	val questionText: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("answerC")
	val answerC: String? = null,

	@field:SerializedName("answerB")
	val answerB: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("answerD")
	val answerD: String? = null,

	@field:SerializedName("correctAnswer")
	val correctAnswer: String? = null,

	@field:SerializedName("answerA")
	val answerA: String? = null,

	@field:SerializedName("categoryId")
	val categoryId: Int? = null
)
