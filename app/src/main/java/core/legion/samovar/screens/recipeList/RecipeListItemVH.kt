package core.legion.samovar.screens.recipeList

import android.net.Uri
import android.view.ViewGroup
import com.bumptech.glide.Glide
import core.legion.samovar.base.BaseVH
import core.legion.samovar.R
import core.legion.samovar.entry.RecipeListItem
import kotlinx.android.synthetic.main.item_recipe_list.view.*

class RecipeListItemVH(parent: ViewGroup, private val recipeListListener: RecipeListFacade.RecipeListListener) : BaseVH<RecipeListItem>(parent, R.layout.item_recipe_list) {

    private lateinit var currentId: String

    override fun bind(item: RecipeListItem) {
        currentId = item.id

        itemView.tvName.text = item.name
        itemView.ivImage.setImageResource(R.drawable.app_icon)
        itemView.setOnClickListener { recipeListListener.onItemClick(item.id) }
    }

    fun bindImage(idUri: Pair<String, Uri>) {
        if (currentId == idUri.first)
            Glide.with(itemView.context)
                    .load(idUri.second)
                    .into(itemView.ivImage)
    }
}