package com.thiqah.newssample.data.source.model

import com.squareup.moshi.Json

data class News(
    @field:Json(name = "id") var id: Int,
    @field:Json(name = "title") var title: String,
    @field:Json(name = "body") var body: String
)