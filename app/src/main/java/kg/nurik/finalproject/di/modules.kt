package kg.nurik.finalproject.di

import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.interactor.InteractorImpl
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.remote.RetrofitBuilder
import kg.nurik.finalproject.data.remote.Service
import kg.nurik.finalproject.data.repository.Repository
import kg.nurik.finalproject.data.repository.RepositoryImpl
import kg.nurik.finalproject.ui.leaguesToCommands.LeaguesToCommandViewModel
import kg.nurik.finalproject.ui.bottomNav.allGames.AllGamesViewModel
import kg.nurik.finalproject.ui.bottomNav.myCommands.MyCommandsViewModel
import kg.nurik.finalproject.ui.commandToPlayers.PlayersViewModel
import kg.nurik.finalproject.ui.countryDetails.CountryDetailsViewModel
import kg.nurik.finalproject.ui.countryLeagues.CountryLeaguesViewModel
import kg.nurik.finalproject.ui.gamesToSeason.GamesSeasonViewModel
import kg.nurik.finalproject.ui.search.SearchViewModel
import kg.nurik.finalproject.ui.topScorers.TopScoresViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { AllGamesViewModel(get(),get()) }
    viewModel { CountryDetailsViewModel(get()) }
    viewModel { CountryLeaguesViewModel(get()) }
    viewModel { GamesSeasonViewModel(get(),get()) }
    viewModel { LeaguesToCommandViewModel(get(),get()) }
    viewModel { PlayersViewModel(get(),get()) }
    viewModel { MyCommandsViewModel(get(),get()) }
    viewModel { TopScoresViewModel(get(),get()) }
    viewModel { SearchViewModel(get(),get()) }
}

val dbModule: Module = module {
    single<CasheAppDatabase> { CasheAppDatabase.getInstanceDB(androidApplication()) }
}

val repositoryModule: Module = module {
    single<Repository> { RepositoryImpl(get(), get()) }
}

val apiModule: Module = module {
    single<Service> { RetrofitBuilder.buildRetrofit() }
    single<Interactor> { InteractorImpl(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule, dbModule)