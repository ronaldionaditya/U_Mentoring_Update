package com.mobile.umentoring.model

import com.google.gson.annotations.SerializedName

data class ResponseClassLeaderboard(

	@field:SerializedName("data")
	val data: List<DataItemClassLeaderboard?>? = null,

	@field:SerializedName("meta")
	val meta: MetaClassLeaderboard? = null
)

data class MetaClassLeaderboard(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class GradeClassLeaderboard(

	@field:SerializedName("submission_19")
	val submission19: Int? = null,

	@field:SerializedName("submission_18")
	val submission18: Int? = null,

	@field:SerializedName("submission_17")
	val submission17: Int? = null,

	@field:SerializedName("submission_16")
	val submission16: Int? = null,

	@field:SerializedName("submission_15")
	val submission15: Int? = null,

	@field:SerializedName("submission_14")
	val submission14: Int? = null,

	@field:SerializedName("submission_13")
	val submission13: Int? = null,

	@field:SerializedName("submission_12")
	val submission12: Int? = null,

	@field:SerializedName("submission_11")
	val submission11: Int? = null,

	@field:SerializedName("submission_10")
	val submission10: Int? = null,

	@field:SerializedName("submission_7")
	val submission7: Int? = null,

	@field:SerializedName("submission_8")
	val submission8: Int? = null,

	@field:SerializedName("submission_9")
	val submission9: Int? = null,

	@field:SerializedName("submission_3")
	val submission3: Int? = null,

	@field:SerializedName("submission_4")
	val submission4: Int? = null,

	@field:SerializedName("submission_5")
	val submission5: Int? = null,

	@field:SerializedName("submission_6")
	val submission6: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("exam_10")
	val exam10: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("exam_2")
	val exam2: Int? = null,

	@field:SerializedName("exam_3")
	val exam3: Int? = null,

	@field:SerializedName("exam_1")
	val exam1: Int? = null,

	@field:SerializedName("exam_6")
	val exam6: Int? = null,

	@field:SerializedName("exam_7")
	val exam7: Int? = null,

	@field:SerializedName("exam_4")
	val exam4: Int? = null,

	@field:SerializedName("exam_5")
	val exam5: Int? = null,

	@field:SerializedName("exam_8")
	val exam8: Int? = null,

	@field:SerializedName("exam_9")
	val exam9: Int? = null,

	@field:SerializedName("participant_id")
	val participantId: Int? = null,

	@field:SerializedName("program_id")
	val programId: Int? = null,

	@field:SerializedName("submission_36")
	val submission36: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("submission_35")
	val submission35: Int? = null,

	@field:SerializedName("submission_34")
	val submission34: Int? = null,

	@field:SerializedName("submission_33")
	val submission33: Int? = null,

	@field:SerializedName("submission_32")
	val submission32: Int? = null,

	@field:SerializedName("submission_31")
	val submission31: Int? = null,

	@field:SerializedName("submission_30")
	val submission30: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("exam_11")
	val exam11: Int? = null,

	@field:SerializedName("submission_29")
	val submission29: Int? = null,

	@field:SerializedName("exam_12")
	val exam12: Int? = null,

	@field:SerializedName("submission_28")
	val submission28: Int? = null,

	@field:SerializedName("submission_27")
	val submission27: Int? = null,

	@field:SerializedName("submission_26")
	val submission26: Int? = null,

	@field:SerializedName("submission_25")
	val submission25: Int? = null,

	@field:SerializedName("submission_1")
	val submission1: Int? = null,

	@field:SerializedName("submission_24")
	val submission24: Int? = null,

	@field:SerializedName("submission_2")
	val submission2: Int? = null,

	@field:SerializedName("submission_23")
	val submission23: Int? = null,

	@field:SerializedName("submission_22")
	val submission22: Int? = null,

	@field:SerializedName("submission_21")
	val submission21: Int? = null,

	@field:SerializedName("submission_20")
	val submission20: Int? = null
)

data class PartisipantClassLeaderboard(

	@field:SerializedName("sekolah")
	val sekolah: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("no_tlp")
	val noTlp: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("angkatan")
	val angkatan: String? = null,

	@field:SerializedName("program_id")
	val programId: Int? = null,

	@field:SerializedName("grade")
	val grade: GradeClassLeaderboard? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class DataItemClassLeaderboard(

	@field:SerializedName("nama_program")
	val namaProgram: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Int? = null,

	@field:SerializedName("partisipant")
	val partisipant: PartisipantClassLeaderboard? = null,

	@field:SerializedName("created_at")
	val createdAt: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("program_image")
	val programImage: String? = null
)
