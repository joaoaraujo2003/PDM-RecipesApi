package com.example.appapi.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appapi.model.Recipe


@Composable
fun RecipesViewCell(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(recipe.name ?: "")
            Text(recipe.ingredients?.joinToString() ?: "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipesViewCellPreview() {
    RecipesViewCell(recipe = Recipe(
        name = "Recipe 1",
        ingredients = listOf("Ingredient 1", "Ingredient 2"),
    ))
}
