package core.legion.samovar.screens.recipeList

import android.graphics.Bitmap
import android.view.ViewGroup
import core.legion.samovar.base.BaseVH
import core.legion.samovar.R
import core.legion.samovar.entry.RecipeListItem
import kotlinx.android.synthetic.main.item_recipe_list.view.*

class RecipeListItemVH(parent: ViewGroup, private val recipeListListener: RecipeListFacade.RecipeListListener) : BaseVH<RecipeListItem>(parent, R.layout.item_recipe_list) {

    private var currentId = ""

    override fun bind(item: RecipeListItem) {
        currentId = item.id

        itemView.tvName.text = item.name
        itemView.ivImage.setImageResource(R.drawable.app_icon)
        itemView.setOnClickListener { recipeListListener.onItemClick(item.id) }
    }

    fun bindImage(id: String, image: Bitmap) {
        if (currentId == id) itemView.ivImage.setImageBitmap(image)
    }
}