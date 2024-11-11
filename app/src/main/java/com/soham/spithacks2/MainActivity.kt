package com.soham.spithacks2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.soham.spithacks2.navigation.BottomNavigationBar
import com.soham.spithacks2.navigation.NavigationScreen
import com.soham.spithacks2.ui.theme.SPITHacks2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            SPITHacks2Theme {
                var navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar {
                            BottomNavigationBar(navController = navController)
                        }
                    }
                ) {
                    NavigationScreen(Modifier.padding(it.calculateTopPadding()),navController)
                }
            }
        }
    }
}
