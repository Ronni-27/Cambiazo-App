//package com.example.cambiazoapp.ui
package com.example.cambiazoapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cambiazoapp.ui.screens.LoginScreen
import com.example.cambiazoapp.ui.screens.RegistroScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        composable("login") {
            LoginScreen(
                onIrARegistro = {
                    navController.navigate("registro")
                },
                onLoginCorrecto = {
                    navController.navigate("inicio") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("registro") {
            RegistroScreen(
                onIrALogin = {
                    navController.popBackStack()
                },
                onRegistroCorrecto = {
                    navController.navigate("inicio") {
                        popUpTo("registro") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("inicio") {
            TextoInicio()
        }
    }
}

@Composable
fun TextoInicio() {
    androidx.compose.material3.Text(
        text = "Bienvenido a Cambiazo"
    )
}
