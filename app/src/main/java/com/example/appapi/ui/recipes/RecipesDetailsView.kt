package com.example.appapi.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appapi.model.Recipe

@Composable
fun RecipeDetailsView( name: String,
                       difficulty: String,
                       time: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Nome: $name")
        Spacer(Modifier.height(8.dp))
        Text("Dificuldade: $difficulty")
        Text("Tempo de preparo: $time minutos")
    }
}