package com.devshady.captone.littlelemon.utils.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.devshady.captone.littlelemon.Destinations
import com.devshady.captone.littlelemon.R

@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    showProfilePic: Boolean = false,
    navHostController: NavHostController? = null
) {
    Box(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
                .align(Alignment.Center)
        )

        if (showProfilePic) {
            Image(
                painter = painterResource(R.drawable.profile_face),
                contentDescription = "logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        if (navHostController != null) {
                            val navBackStackEntry = navHostController.currentBackStackEntry
                            val currentRoute = navBackStackEntry?.destination?.route
                            val expectedRoute =
                                "com.devshady.captone.littlelemon.Destinations." + Destinations.Profile.route

                            if (currentRoute != expectedRoute) {
                                navHostController?.navigate(Destinations.Profile)
                            }
                        }

                    }
                    .align(Alignment.CenterEnd)
            )
        }
    }

}

@Preview
@Composable
fun HeaderComponentPreview() {
    HeaderComponent()
}