package com.example.logeofirebase.view.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.logeofirebase.components.Alert
import com.example.logeofirebase.viewmodel.LoginViewModel
import androidx.compose.ui.Modifier


@Composable
fun RegisterView(navController: NavController, loginViewModel: LoginViewModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        var email by remember {mutableStateOf(value = "")}
        var password by remember {mutableStateOf(value = "")}
        var userName by remember {mutableStateOf(value = "")}

        OutlinedTextField(
            value = userName,
            onValueChange = {userName = it},
            label = { Text(text = "UserName")},
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp,)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "email")},
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp,)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp,)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {loginViewModel.register(email = email, password = password, userName = userName){
            navController.navigate("home")
        }}, modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp,)) {
            Text(text = "Registrar")
        }

        if(loginViewModel.showAlert){
            Alert(title = "Error", message = "Error al registrar", confirm = "Aceptar", onConfirm = {loginViewModel.closeAler()}){
            }
        }
    }
}