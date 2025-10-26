package com.example.appapi.ui.recipes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.appapi.model.Recipe
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class RecipesListViewModel : ViewModel() {
    var recipes = mutableStateOf<List<Recipe>>(emptyList())
        private set
    var errorMessage = mutableStateOf<String?>(null)
        private set
    fun LoadRecipes(source: String){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://dummyjson.com/recipes")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                errorMessage.value = "Erro: ${e.message}"
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        errorMessage.value = "Erro: ${response.code}"
                        return
                    }

                    val json = JSONObject(it.body!!.string())
                    val jsonArray = json.getJSONArray("recipes")
                    val tempList = mutableListOf<Recipe>()

                    for (i in 0 until jsonArray.length()) {
                        val obj = jsonArray.getJSONObject(i)
                        tempList.add(Recipe.fromJson(obj))
                    }

                    recipes.value = tempList
                }
        }
        })
    }
}