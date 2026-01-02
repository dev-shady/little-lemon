package com.devshady.captone.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devshady.captone.littlelemon.utils.common.HeaderComponent

class Home {

    @Composable
    fun HomeComposable(context: Context, navHostController: NavHostController) {
        Column {
            HeaderComponent(
                Modifier
                    .padding(0.dp, 16.dp, 0.dp, 8.dp)
                    .fillMaxWidth())
            Box(
                modifier = Modifier
                    .padding(0.dp, 16.dp, 16.dp, 0.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(48.dp, height = 48.dp)
                        .clickable {
                            navHostController.navigate(Destinations.Profile)
                        }
                )
            }

        }
    }

    @Preview
    @Composable
    fun HomeComposablePreview() {
        val navHostController = rememberNavController()
        HomeComposable(LocalContext.current, navHostController)
    }
}