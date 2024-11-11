package com.soham.spithacks2.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.soham.spithacks2.ui.theme.darkBlue

@Composable
fun BottomNavigationBar(navController: NavHostController){
    val navItems = listOf(NavItem.Home,NavItem.Discover,NavItem.History)
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar (
        containerColor = Color.White
    ){
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = true,
                icon = {
                    Image(
                        painterResource(id = if(selectedItem==index){ item.selectedICon} else{item.Icon}) ,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = darkBlue,
                ),
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route){
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                )

        }
    }
}