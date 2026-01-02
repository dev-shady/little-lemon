package com.devshady.captone.littlelemon.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Menu(
    @SerialName("menu") val menuItems: List<MenuItem>
)