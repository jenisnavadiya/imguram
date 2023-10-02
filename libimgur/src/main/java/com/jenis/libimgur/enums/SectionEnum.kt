package com.jenis.libimgur.enums

import com.squareup.moshi.Json

enum class SectionEnum {
    @Json(name = "hot" )
    HOT,
    @Json(name = "top" )
    TOP
}