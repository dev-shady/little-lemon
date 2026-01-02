package com.devshady.captone.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.devshady.captone.littlelemon.ui.theme.LittleLemonTheme
import com.devshady.captone.littlelemon.utils.PrefKeys
import com.devshady.captone.littlelemon.utils.common.HeaderComponent

class Profile {

    @Composable
    fun ProfileComposable(context: Context, navHostController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .safeDrawingPadding(),
        ) {
            val preferences =
                context.getSharedPreferences(PrefKeys.KEY_USER_PREFS, Context.MODE_PRIVATE)
            /*---------------Header---------------------*/
            HeaderComponent(
                Modifier
                    .padding(0.dp, 16.dp, 0.dp, 0.dp)
                    .fillMaxWidth())

            /*----Wrapper to take all extra space available----*/
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {

                /*--------------Profile Information----------------------*/
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        "Personal Information:",
                        color = Color.Black,
                        fontSize = 18.sp,
                        lineHeight = 36.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                /*-----First Name, Last Name, Email Info----*/

                Column() {
                    val firstName = preferences.getString(PrefKeys.KEY_FIRST_NAME, "").orEmpty()
                    val lastName = preferences.getString(PrefKeys.KEY_LAST_NAME, "").orEmpty()
                    val email = preferences.getString(PrefKeys.KEY_EMAIL, "").orEmpty()
                    Text(
                        "First Name",
                        color = Color.Gray,
                        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 8.dp)
                    )
                    Text(
                        firstName,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 8.dp, 0.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(16.dp, 16.dp, 16.dp, 16.dp),


                        )

                    Text(
                        text = "Last Name",
                        color = Color.Gray,
                        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 8.dp)
                    )
                    Text(
                        lastName,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 8.dp, 0.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(16.dp, 16.dp, 16.dp, 16.dp),


                        )

                    Text(
                        "Email",
                        color = Color.Gray,
                        modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 8.dp)
                    )
                    Text(
                        email,
                        color = Color.DarkGray,
                        modifier = Modifier
                            .padding(8.dp, 0.dp, 8.dp, 0.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .padding(16.dp, 16.dp, 16.dp, 16.dp),


                        )
                }

            }

            /*--------------Logout Button----------------------*/

            Button(
                onClick = {
                    preferences.edit().clear().apply()
                    navHostController.navigate(Destinations.Onboarding) {
                        popUpTo(0) {
                            inclusive = false
                        }
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Logout")
            }
        }


    }

    @Preview
    @Composable
    fun ProfileComposablePreview() {
        val navHostController = rememberNavController()
        LittleLemonTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.White
            )
            { innerPadding ->
                ProfileComposable(
                    LocalContext.current,
                    navHostController
                )
            }
        }
    }


}