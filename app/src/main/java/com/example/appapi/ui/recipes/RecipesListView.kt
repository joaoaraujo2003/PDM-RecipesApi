package com.example.appapi.ui.recipes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appapi.model.Recipe
import com.example.appapi.ui.components.RecipeCard


@Composable
fun RecipesListView(
    navController: NavController,
    source: String,
    modifier: Modifier = Modifier
) {
    val viewModel: RecipesListViewModel = viewModel()
    val recipes = viewModel.recipes.value
    val error = viewModel.errorMessage.value

    LaunchedEffect(Unit) {
        viewModel.LoadRecipes(source)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        when {
            error != null -> Text(text = error)
            recipes.isEmpty() -> Text(text = "A carregar receitas...")
            else -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(recipes) { recipe ->
                        RecipeCard(recipe = recipe) {
                            navController.navigate(
                                "recipeDetail/${recipe.name}/${recipe.difficulty}/${recipe.cookTimeMinutes}"
                            )
                        }
                    }
                }
            }
        }
    }
}



