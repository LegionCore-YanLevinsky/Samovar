package core.legion.samovar.data

import core.legion.samovar.entry.RecipeItem
import core.legion.samovar.entry.RecipeListItem
import io.reactivex.Completable
import io.reactivex.Single

interface DBManager {
    fun getApprovedRecipeList(): Single<ArrayList<RecipeListItem>>
    fun getReviewedRecipeList(): Single<ArrayList<RecipeListItem>>

    fun getApprovedRecipe(id: String): Single<RecipeItem>
    fun getReviewedRecipe(id: String): Single<RecipeItem>

    fun addRecipeToReview(name: String, description: String): Completable
}