package com.soham.spithacks2.navigation

import com.soham.spithacks2.R

sealed class NavItem(
    val title: String,
    val Icon: Int,
    val route:String,
    val selectedICon: Int
){
    object Home:NavItem("Home", R.drawable.house,"home", selectedICon = R.drawable.house)
    object Discover:NavItem("LeaderBoard",R.drawable.podium,"leaderboard", selectedICon = R.drawable.podium)
    object History:NavItem("Add Donation",R.drawable.donate,"make donation", selectedICon = R.drawable.donate)
//    object Reward:NavItem("Reward",R.drawable.dashboard,"reward", selectedICon = R.drawable.dashboard)
}