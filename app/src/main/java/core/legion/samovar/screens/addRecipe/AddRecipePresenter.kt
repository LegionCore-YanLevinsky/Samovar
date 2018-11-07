package core.legion.samovar.screens.addRecipe

import android.content.Intent
import core.legion.samovar.data.contentManager.ContentManager
import core.legion.samovar.data.firebaseManager.DBManager
import core.legion.samovar.utils.BitmapUtils

class AddRecipePresenter(val view: AddRecipeFacade.View, var interactor: AddRecipeFacade.Interactor, var firebase: DBManager, var contentManager: ContentManager) : AddRecipeFacade.Presenter, AddRecipeFacade.OnIngredientChangeListener {

    private var image: ByteArray = ByteArray(0)
    private var name = ""
    private var description = ""

    override fun onViewInit() {
        interactor.getIngredients().subscribe(view::showIngredients)
//        interactor.getEquipment().subscribe(view::showEquipment)
//        interactor.getRecipe().subscribe(view::showRecipe)
    }

    override fun onNameChanged(name: String) {
        this.name = name
    }

    override fun onDescriptionChanged(description: String) {
        this.description = description
    }

    override fun onImageClick() = view.showChooseImageDialog()

    override fun onAddClick() {
        firebase.addRecipe(name, description, image).subscribe { view.closeView() }
    }

    override fun onImageFromGallery(data: Intent) {
        contentManager.getImageFromUri(data.data).subscribe { image ->
            BitmapUtils.getBytes(image).subscribe { bytes -> this.image = bytes }
            view.showImage(image)
        }
    }

    override fun onIngredientChange(pos: Int, ingredient: String) {
    }
}
