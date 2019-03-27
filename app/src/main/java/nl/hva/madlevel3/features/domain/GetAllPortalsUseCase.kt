package nl.hva.madlevel3.features.domain

import nl.hva.madlevel3.core.interactor.UseCase
import nl.hva.madlevel3.features.data.models.Portal
import nl.hva.madlevel3.features.data.repositories.PortalRepository

class GetAllPortalsUseCase(private val portalRepository: PortalRepository) :
        UseCase<Array<Portal>, UseCase.None>() {

    override suspend fun run(params: None) = portalRepository.retrievePortals()

}