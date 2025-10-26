package com.example.appapi.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appapi.model.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick : (Recipe) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(recipe) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(recipe.name ?: "Sem nome")
            Text("Dificuldade: ${recipe.difficulty ?: "N/A"}")
            Text("Tempo: ${recipe.cookTimeMinutes ?: 0} min")
        }
    }
}