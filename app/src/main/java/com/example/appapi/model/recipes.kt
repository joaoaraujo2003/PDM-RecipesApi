package com.example.appapi.model

import org.json.JSONObject

data class Recipe(
    var id                  : Int ? = null,
    var name                : String? = null,
    var ingredients         : List<String> ? = null,
    var instructions        : List<String> ? = null,
    var prepTimeMinutes     : Int ? = null,
    var cookTimeMinutes     : Int ? = null,
    var servings            : Int ? = null,
    var difficulty          : String? = null,
    var cuisine             : String? = null,
    var caloriesPerServing  : Int ? = null,
    var tags                : List<String> ? = null,
    var userId              : Int ? = null,
    var image               : String ? = null,
    var rating              : Double ? =null,
    var reviewCount         : Int ? = null,
    var mealType            : List<String> ? = null
    ) {
    companion object {
        fun fromJson(jsonObject : JSONObject) : Recipe {
            val recipe = Recipe()
                recipe.id = jsonObject.getInt("id")
                recipe.name = jsonObject.getString("name")
                val ingredients = jsonObject.getJSONArray("ingredients")
                val ingredientsList = arrayListOf<String>()
                for (index in 0 until ingredients.length()){
                    ingredientsList.add(ingredients.getString(index))
                }
                recipe.ingredients = ingredientsList
                val instructions = jsonObject.getJSONArray("instructions")
                val instructionsList = arrayListOf<String>()
                for (index in 0 until instructions.length()){
                    instructionsList.add(instructions.getString(index))
                }
                recipe.instructions = instructionsList
                recipe.prepTimeMinutes = jsonObject.getInt("prepTimeMinutes")
                recipe.cookTimeMinutes = jsonObject.getInt("cookTimeMinutes")
                recipe.servings = jsonObject.getInt("servings")
                recipe.difficulty = jsonObject.getString("difficulty")
                recipe.cuisine = jsonObject.getString("cuisine")
                recipe.caloriesPerServing = jsonObject.getInt("caloriesPerServing")
                val tags = jsonObject.getJSONArray("tags")
                val tagsList = arrayListOf<String>()
                for (index in 0 until tags.length()){
                    tagsList.add(tags.getString(index))
                }
                recipe.userId = jsonObject.getInt("userId")
                recipe.image = jsonObject.getString("image")
                recipe.rating = jsonObject.getDouble("rating")
                recipe.reviewCount =  jsonObject.getInt("reviewCount")
                val mealType = jsonObject.getJSONArray("mealType")
                val mealTypeList = arrayListOf<String>()
                for (index in 0 until mealType.length()){
                    mealTypeList.add(mealType.getString(index))
                }
                recipe.mealType = mealTypeList
                return recipe
        }
    }
}