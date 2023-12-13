package com.freeapp.coffeeappwithcompose.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freeapp.coffeeappwithcompose.model.CoffeeItem

@Composable
fun NavGraph() {

    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen"){

        composable("home_screen"){
            HomeScreen(navController)
        }
        composable("detail_screen"){
            val coffeeItem = navController.previousBackStackEntry?.savedStateHandle?.get<CoffeeItem>("coffeeItem")

            coffeeItem?.let {
                 DetailScreen(coffeeItem)
            }
            }
        }
    }