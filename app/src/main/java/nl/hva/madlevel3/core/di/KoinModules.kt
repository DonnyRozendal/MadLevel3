package nl.hva.madlevel3.core.di

import androidx.room.Room
import nl.hva.madlevel3.features.data.repositories.PortalRepository
import nl.hva.madlevel3.features.data.room.PortalDatabase
import nl.hva.madlevel3.features.domain.GetAllPortalsUseCase
import nl.hva.madlevel3.features.domain.InsertPortalUseCase
import nl.hva.madlevel3.features.presentation.addportal.AddPortalViewModel
import nl.hva.madlevel3.features.presentation.portallist.PortalListViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory

val applicationModule = module {
    viewModel<PortalListViewModel>()
    viewModel<AddPortalViewModel>()
}

val useCaseModule = module {
    factory<InsertPortalUseCase>()
    factory<GetAllPortalsUseCase>()
}

val repositoryModule = module {
    single<PortalRepository> { PortalRepository.Network(get()) }
}

val roomModule = module {
    single { Room.databaseBuilder(get(), PortalDatabase::class.java, "portal-db").build() }
    single { get<PortalDatabase>().portalDao() }
}

val koinModules = listOf(
        applicationModule,
        useCaseModule,
        repositoryModule,
        roomModule
)