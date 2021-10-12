package com.mobile.umentoring.model

data class DataProgram(
    val created_at: Int,
    val deleted_at: Any,
    val id: Int,
    val nama_program: String,
    val partisipant: Partisipant,
    val program_image: String,
    val updated_at: Int
)