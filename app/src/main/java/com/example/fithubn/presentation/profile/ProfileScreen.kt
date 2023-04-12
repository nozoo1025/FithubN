package com.example.fithubn.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fithubn.presentation.profile.viewmodel.ProfileEffect
import com.example.fithubn.presentation.profile.viewmodel.ProfileEvent
import com.example.fithubn.presentation.profile.viewmodel.ProfileViewModel
import com.example.fithubn.presentation.util.use

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    val (state, effectFlow, dispatch) = use(viewModel)

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = state.name,
                label = { Text("名前") },
                onValueChange = {
                    dispatch(ProfileEvent.OnNameChanged(it))
                },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1
            )
            OutlinedTextField(
                value = state.dateOfBirth,
                label = { Text("誕生日") },
                onValueChange = {
                    dispatch(ProfileEvent.OnDateOfBirthChanged(it))
                },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1
            )
            OutlinedTextField(
                value = state.bio,
                label = { Text("自己紹介") },
                onValueChange = {
                    dispatch(ProfileEvent.OnBioChanged(it))
                },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    dispatch(ProfileEvent.OnSaveClicked)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("保存")
            }
        }
    }

    LaunchedEffect(effectFlow) {
        effectFlow.collect { effect ->
            when (effect) {
                is ProfileEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = context.getString(effect.messageId)
                    )
                }
            }
        }
    }
}