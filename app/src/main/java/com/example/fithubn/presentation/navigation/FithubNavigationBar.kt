package com.example.fithubn.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.fithubn.R

@Composable
fun FithubNavigationBar(navActions: FithubNavigationAction, currentRoute: String) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, null) },
            label = { Text(stringResource(R.string.screen_title_body_metrics_history)) },
            selected = currentRoute == FithubDestinations.BODY_METRICS_ROUTE,
            onClick = navActions::navigateToBodyMetrics,
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, null) },
            label = { Text(stringResource(R.string.screen_title_body_metrics)) },
            selected = currentRoute == FithubDestinations.PROFILE_ROUTE,
            onClick = navActions::navigateToProfile,
        )
    }
}