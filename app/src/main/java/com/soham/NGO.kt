package com.soham

import com.google.android.gms.maps.model.LatLng

data class NGO(
    val name: String,
    val location: LatLng,
    val members: String,
    val feeding: String,
    val donorImage: String,
    val foodImage: String
)
