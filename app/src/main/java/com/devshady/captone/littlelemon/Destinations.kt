package com.devshady.captone.littlelemon

import kotlinx.serialization.Serializable

sealed interface Destinations {

    val route: String

    @Serializable
    object Home : Destinations {
        override val route: String
            get() = TODO("Home")
    }

    @Serializable
    object Onboarding : Destinations {
        override val route: String
            get() = "Onboarding"
    }

    @Serializable
    object Profile : Destinations {
        override val route: String
            get() = "Profile"
    }
}