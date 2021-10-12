package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("data")
	val data: DataRegister? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)

data class DataRegister(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class MetaRegister(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
