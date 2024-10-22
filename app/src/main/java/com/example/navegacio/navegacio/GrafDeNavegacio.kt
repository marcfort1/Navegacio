package com.example.navegacio.navegacio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navegacio.ui.pantalles.PantallaCaraCreu
import com.example.navegacio.ui.pantalles.PantallaRangeSelector
import com.example.navegacio.ui.pantalles.PantallaPrincipal
import com.example.navegacio.ui.pantalles.PantallaRandomNumber

@Composable
fun GrafDeNavegacio(
    navController: NavHostController,
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(
        navController = navController,
        startDestination = "Principal",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("Principal") {
            PantallaPrincipal(
                OnCaraCreuClick = { navController.navigate("CaraCreu") },
                OnNumRndClick = { navController.navigate("NumRND") },
                OnPreguntaClick = { navController.navigate("Pregunta") }
            )
        }
        composable("CaraCreu") {
            PantallaCaraCreu(
                cara = (0..1).random() == 1,
                onTornarClick = { navController.popBackStack() }
            )
        }
        composable("NumRND") {
            PantallaRangeSelector(
                onGenerarRandomClick = { randomNumber ->
                    navController.navigate("Resultat/$randomNumber")
                }
            )
        }
        composable(
            route = "Resultat/{randomNumber}",
            arguments = listOf(navArgument("randomNumber") { type = androidx.navigation.NavType.IntType })
        ) { backStackEntry ->
            val randomNumber = backStackEntry.arguments?.getInt("randomNumber") ?: 0
            PantallaRandomNumber(
                randomNumber = randomNumber,
                onTornarClick = { navController.popBackStack("Principal", inclusive = false) }
            )
        }
    }
}
