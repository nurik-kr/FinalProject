package kg.nurik.finalproject.di

import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.interactor.InteractorImpl
import kg.nurik.finalproject.data.remote.RetrofitBuilder
import kg.nurik.finalproject.data.remote.Service
import kg.nurik.finalproject.data.repository.Repository
import kg.nurik.finalproject.data.repository.RepositoryImpl
import kg.nurik.finalproject.ui.bottomNav.allGames.AllGamesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { AllGamesViewModel(get()) }
}

val repositoryModule: Module = module {
    single<Repository> { RepositoryImpl(get()) }
}

val apiModule: Module = module {
    single<Service> { RetrofitBuilder.buildRetrofit() }
    single<Interactor> { InteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)