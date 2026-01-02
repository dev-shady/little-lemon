package com.devshady.captone.littlelemon.utils.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.devshady.captone.littlelemon.R

@Composable
fun HeaderComponent(modifier: Modifier = Modifier, alignment: Alignment = Alignment.Center) {
    Box(
        modifier = modifier,
        contentAlignment = alignment
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp, height = 50.dp)
        )
    }
}