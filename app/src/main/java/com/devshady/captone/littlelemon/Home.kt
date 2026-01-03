package com.devshady.captone.littlelemon

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.devshady.captone.littlelemon.database.AppDatabase
import com.devshady.captone.littlelemon.database.MenuItemRoom
import com.devshady.captone.littlelemon.ui.theme.Cloud
import com.devshady.captone.littlelemon.ui.theme.CustomOutlineTextField
import com.devshady.captone.littlelemon.ui.theme.DarkGreen
import com.devshady.captone.littlelemon.ui.theme.LittleLemonTheme
import com.devshady.captone.littlelemon.ui.theme.Yellow
import com.devshady.captone.littlelemon.utils.common.HeaderComponent

class Home {

    @Composable
    fun HomeComposable(context: Context, navHostController: NavHostController) {
        val menuItemsLive = remember {
            AppDatabase.getDatabase(context).menuDao().getAll()
        }
        val menuItems by menuItemsLive.observeAsState(emptyList())
        Column {
            HeaderComponent(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                showProfilePic = true,
                navHostController = navHostController
            )
            Hero()
            CategoryFilters(menuItems)
            MenuItems(menuItems)
        }
    }

    @Composable
    fun CategoryFilters(items: List<MenuItemRoom>) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Order For Delivery!",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(8.dp))
            val categories = mutableSetOf<String>()
            for (item in items) {
                categories.add(item.category)
            }

            val scrollState = rememberScrollState()
            Row(
                Modifier
                    .horizontalScroll(scrollState)
            ) {
                for (category in categories) {
                    val formattedCategory = category.replaceFirstChar { it.uppercase() }
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .background(Cloud, shape = RoundedCornerShape(50.dp))
                            .padding(12.dp, 8.dp, 12.dp, 8.dp),

                        ) {
                        Text(
                            text = formattedCategory,
                            color = Color.DarkGray,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                }
            }
            Spacer(Modifier.height(24.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray
            )
        }
    }

    @Composable
    fun MenuItems(menuItems: List<MenuItemRoom>) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            menuItems.forEach {
                MenuItem(it)
            }
        }
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun MenuItem(item: MenuItemRoom) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = item.title,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.70f)
                        .padding(4.dp)
                ) {
                    Text(
                        text = item.description,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$${item.price}",
                        color = Color.DarkGray
                    )
                }
                GlideImage(
                    model = item.image,
                    contentDescription = "food",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
            }
        }
    }

    @Composable
    fun Hero() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkGreen)
                .padding(16.dp)
        ) {
            Text(
                text = "Little Lemon",
                fontSize = 30.sp,
                letterSpacing = 2.sp,
                color = Yellow
            )
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                ) {
                    Text(
                        text = "Chicago",
                        fontSize = 24.sp,
                        color = Cloud
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                        fontSize = 16.sp,
                        color = Cloud
                    )

                }
                Image(
                    painter = painterResource(R.drawable.hero_image),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
//                navHostController.navigate(Destinations.Profile)
                        }
                        .width(200.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(12.dp))
                )

            }
            var searchPhrase by remember {
                mutableStateOf("")
            }
            CustomOutlineTextField(
                value = searchPhrase,
                onValueChange = { searchPhrase = it },
                placeHolder = "Enter search phrase",
                modifier = Modifier
                    .padding(0.dp, 16.dp, 0.dp, 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }

    @Preview
    @Composable
    fun HomeComposablePreview() {
        val navHostController = rememberNavController()
        LittleLemonTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = Color.White
            )
            { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) {
                    HomeComposable(LocalContext.current, navHostController)
                }
            }
        }

    }
}