package com.devshady.captone.littlelemon

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class NavigationComposable {

    @Composable
    fun Navigation(context: Context, navHostController: NavHostController) {

        val preferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val isUserLoggedIn = preferences.getBoolean("userLoggedIn", false)
        val startDestination = if (isUserLoggedIn) {
            Destinations.Home
        } else {
            Destinations.Onboarding
        }

        NavHost(
            navController = navHostController, startDestination = startDestination
        ) {
            composable<Destinations.Home> {
                Home().HomeComposable()
            }
            composable<Destinations.Onboarding> {
                Onboarding().OnboardingComposable(context, navHostController)
            }
            composable<Destinations.Profile> {
                Profile().ProfileComposable()
            }
        }
    }
}