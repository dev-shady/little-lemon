package com.devshady.captone.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devshady.captone.littlelemon.ui.theme.CustomOutlineTextField
import com.devshady.captone.littlelemon.ui.theme.LittleLemonTheme
import com.devshady.captone.littlelemon.utils.PrefKeys
import com.devshady.captone.littlelemon.utils.common.HeaderComponent

class Onboarding {

    @Composable
    fun OnboardingComposable(context: Context, navHostController: NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            HeaderComponent( Modifier
                .padding(0.dp, 16.dp, 0.dp, 8.dp)
                .fillMaxWidth())
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFF495E57)),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = "Let's get To know you",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Personal Information",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(10.dp, 5.dp, 10.dp, 5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            }

            var firstName by remember {
                mutableStateOf("")
            }
            var lastName by remember {
                mutableStateOf("")
            }
            var email by remember {
                mutableStateOf("")
            }
            Text(
                "First Name",
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                color = Color.DarkGray
            )
            CustomOutlineTextField(
                value = firstName,
                onValueChange = { firstName = it },
                modifier = Modifier
                    .padding(10.dp, 5.dp, 10.dp, 5.dp)
                    .fillMaxWidth(),
            )
            Text(
                "Last Name",
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                color = Color.DarkGray
            )
            CustomOutlineTextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier
                    .padding(10.dp, 5.dp, 10.dp, 5.dp)
                    .fillMaxWidth(),
            )
            Text(
                "Email",
                modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                color = Color.DarkGray
            )
            CustomOutlineTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .padding(10.dp, 5.dp, 10.dp, 5.dp)
                    .fillMaxWidth(),
            )
            Button(
                onClick = {
                    if (!(firstName.isBlank() || lastName.isBlank() || email.isBlank())) {
                        Toast
                            .makeText(context, "Registration Successful!", Toast.LENGTH_SHORT)
                            .show()
                        val preferences =
                            context.getSharedPreferences(
                                PrefKeys.KEY_USER_PREFS,
                                Context.MODE_PRIVATE
                            )
                        val editor = preferences.edit()
                        editor.putString(PrefKeys.KEY_FIRST_NAME, firstName)
                        editor.putString(PrefKeys.KEY_LAST_NAME, lastName)
                        editor.putString(PrefKeys.KEY_EMAIL, email)
                        editor.putBoolean(PrefKeys.KEY_USER_LOGGED_IN, true)
                        editor.apply()
                        navHostController.navigate(Destinations.Home) {
                            popUpTo(0) {
                                inclusive = false
                            }
                        }
                    } else {
                        Toast
                            .makeText(
                                context,
                                "Registration Unsuccessful. Please enter all the data ",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp, 10.dp, 5.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Register")
            }
        }
    }

    @Preview
    @Composable
    fun OnboardingComposablePreview() {
        val navController = rememberNavController()
        LittleLemonTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.White
            )
            { innerPadding ->
                OnboardingComposable(LocalContext.current, navController)
            }
        }
    }
}