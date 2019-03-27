package nl.hva.madlevel3.features.presentation.portallist

import nl.hva.madlevel3.core.functional.SingleLiveEvent
import nl.hva.madlevel3.core.interactor.UseCase
import nl.hva.madlevel3.core.platform.BaseViewModel
import nl.hva.madlevel3.features.data.models.Portal
import nl.hva.madlevel3.features.domain.GetAllPortalsUseCase

class PortalListViewModel(private val getAllPortalsUseCase: GetAllPortalsUseCase) : BaseViewModel() {

    val portals = SingleLiveEvent<Array<Portal>>()

    fun getAllPortals() {
        getAllPortalsUseCase(UseCase.None()) {
            it.either(::handleFailure) { result -> portals.setValue(result) }
        }
    }

}