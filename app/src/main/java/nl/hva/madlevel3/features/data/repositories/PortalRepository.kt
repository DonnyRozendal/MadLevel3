package nl.hva.madlevel3.features.data.repositories

import nl.hva.madlevel3.core.exception.Failure
import nl.hva.madlevel3.core.functional.Either
import nl.hva.madlevel3.features.data.models.Portal
import nl.hva.madlevel3.features.data.room.PortalDao

interface PortalRepository {

    fun insertPortal(portal: Portal): Either<Failure, Boolean>

    fun retrievePortals(): Either<Failure, Array<Portal>>

    class Network(private val portalDao: PortalDao): PortalRepository {

        override fun insertPortal(portal: Portal): Either<Failure, Boolean> {
            portalDao.insert(portal)
            return Either.Right(true)
        }

        override fun retrievePortals(): Either<Failure, Array<Portal>> {
            return Either.Right(portalDao.getAll() ?: emptyArray())
        }

    }

}