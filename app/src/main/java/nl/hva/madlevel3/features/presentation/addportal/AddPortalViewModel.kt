package nl.hva.madlevel3.features.presentation.addportal

import androidx.lifecycle.MutableLiveData
import nl.hva.madlevel3.core.platform.BaseViewModel
import nl.hva.madlevel3.features.data.models.Portal
import nl.hva.madlevel3.features.domain.InsertPortalUseCase

class AddPortalViewModel(private val insertPortalUseCase: InsertPortalUseCase) : BaseViewModel() {

    val added = MutableLiveData<Boolean>()

    fun addPortal(portal: Portal) {
        insertPortalUseCase(InsertPortalUseCase.Params(portal)) {
            it.either(::handleFailure) { result ->
                added.setValue(result)
            }
        }
    }

}