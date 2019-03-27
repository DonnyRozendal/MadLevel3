package nl.hva.madlevel3.features.domain

import nl.hva.madlevel3.core.interactor.UseCase
import nl.hva.madlevel3.features.data.models.Portal
import nl.hva.madlevel3.features.data.repositories.PortalRepository

class InsertPortalUseCase(private val portalRepository: PortalRepository) :
        UseCase<Boolean, InsertPortalUseCase.Params>() {

    override suspend fun run(params: Params) = portalRepository.insertPortal(params.portal)

    data class Params(val portal: Portal)

}