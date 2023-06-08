package com.caps.rempasi.domain.repository

import com.caps.rempasi.data.local.entity.RecipeEntity
import com.caps.rempasi.data.remote.response.PredictionsItem
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun imageDetection(): Flow<List<PredictionsItem>>
    fun getRecipes(keyword: List<String>): Flow<List<RecipeEntity>>
    fun getDetailRecipeById(id: Int): Flow<RecipeEntity>
    fun searchSavedRecipes(query: String): Flow<List<RecipeEntity>>
    suspend fun setSaved(recipe: RecipeEntity, isSaved: Boolean)
}