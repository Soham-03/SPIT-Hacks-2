package com.soham.spithacks2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.soham.spithacks2.screens.AddDonationScreen
import com.soham.spithacks2.screens.HomeScreen
import com.soham.spithacks2.screens.NGOLeaderboardScreen

@Composable
fun NavigationScreen(modifier: Modifier, navController: NavHostController){
    NavHost(navController = navController, startDestination = NavItem.Home.route) {
        composable(NavItem.Home.route) { HomeScreen() }
        composable(NavItem.Discover.route) { NGOLeaderboardScreen()}
        composable(NavItem.History.route) { AddDonationScreen() }
//        composable(NavItem.Reward.route) { HomeScreen() }
    }
}