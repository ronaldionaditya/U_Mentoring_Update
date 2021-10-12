package com.mobile.umentoring.model

data class Partisipant(
    val angkatan: String,
    val created_at: Int,
    val deleted_at: Any,
    val email: String,
    val grade: Grade,
    val id: Int,
    val image: String,
    val name: String,
    val no_tlp: String,
    val program_id: Int,
    val sekolah: String,
    val updated_at: Int
)