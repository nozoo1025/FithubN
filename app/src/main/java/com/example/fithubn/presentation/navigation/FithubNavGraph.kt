package com.example.fithubn.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fithubn.presentation.bodymetricslist.BodyMetricsListScreen
import com.example.fithubn.presentation.profile.ProfileScreen

@Composable
fun FithubNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = FithubDestinations.BODY_METRICS_ROUTE,
    navActions: FithubNavigationAction = remember(navController) {
        FithubNavigationAction(navController)
    }
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    Scaffold(
        bottomBar = { FithubNavigationBar(navActions, currentRoute) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(FithubDestinations.BODY_METRICS_ROUTE) {
                BodyMetricsListScreen()
            }
            composable(FithubDestinations.PROFILE_ROUTE) {
                ProfileScreen()
            }
        }
    }
}