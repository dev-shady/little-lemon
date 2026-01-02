package com.devshady.captone.littlelemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.devshady.captone.littlelemon.database.AppDatabase
import com.devshady.captone.littlelemon.network.Menu
import com.devshady.captone.littlelemon.network.MenuItem
import com.devshady.captone.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    val database by lazy {
        AppDatabase.getDatabase(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White
                )
                { innerPadding ->
                    Box(modifier = Modifier.padding((innerPadding))) {
                        MainScreen()
                    }
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuDao().isEmpty()) {
                val menuItems = fetchMenu()
                saveToDatabase(menuItems)
            }
        }
    }

    suspend fun fetchMenu(): List<MenuItem> {
        val URL =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val menu: Menu = httpClient.get(URL).body()
        Log.e("aamku: ", menu.toString())
        return menu?.menuItems ?: emptyList()
    }

    suspend fun saveToDatabase(menuItems: List<MenuItem>) {
        val menuItemsRoom = menuItems.map { it.toMenuItemRoom() }
        database.menuDao().insertAll(menuItemsRoom)
        Log.e("aamku: ", "insertAll successful")
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        NavigationComposable().Navigation(
            LocalContext.current,
            navHostController = navController
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }
}
