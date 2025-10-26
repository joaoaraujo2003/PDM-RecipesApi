package com.example.appapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.appapi.ui.recipes.RecipesListView
import com.example.appapi.ui.theme.AppApiTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appapi.ui.recipes.RecipeDetailsView

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            var title by remember { mutableStateOf("Receitas") }
            var isHome by remember { mutableStateOf(true) }

            AppApiTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(title) },
                            navigationIcon = {
                                if (!isHome) {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowBack,
                                            contentDescription = "Voltar"
                                        )
                                    }
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "recipesList",
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable("recipesList") {
                            isHome = true
                            title = "Lista de Receitas"
                            RecipesListView(
                                navController = navController,
                                source = "dummyjson"
                            )
                        }

                        composable("recipeDetail/{name}/{difficulty}/{time}") { backStackEntry ->
                            isHome = false
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            val difficulty = backStackEntry.arguments?.getString("difficulty") ?: ""
                            val time = backStackEntry.arguments?.getString("time") ?: "0"
                            title = name
                            RecipeDetailsView(
                                name = name,
                                difficulty = difficulty,
                                time = time.toInt()
                            )
                        }
                    }
                }
            }
        }
    }
}

