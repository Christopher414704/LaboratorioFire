package com.example.logeofirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.logeofirebase.view.login.BlankView
import com.example.logeofirebase.view.login.TabsView
import com.example.logeofirebase.view.notas.HomeView
import com.example.logeofirebase.viewmodel.LoginViewModel
import com.example.logeofirebase.viewmodel.NotesViewModel

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NotesViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("blank"){
            BlankView(navController = navController)
        }
        composable("login"){
            TabsView(navController = navController, loginViewModel = LoginViewModel())
        }
        composable("home"){
            HomeView(navController = navController, viewModel = NotesViewModel())
    }
    }
}