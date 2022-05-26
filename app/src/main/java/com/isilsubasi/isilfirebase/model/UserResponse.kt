package com.isilsubasi.isilfirebase.model

data class UserResponse(
    val documents: List<Document>
) {
    data class Document(
        val createTime: String,
        val fields: Fields,
        val name: String,
        val updateTime: String
    ) {
        data class Fields(
            val adi: Adi,
            val no: No
        ) {
            data class Adi(
                val stringValue: String
            )

            data class No(
                val integerValue: String
            )
        }
    }
}