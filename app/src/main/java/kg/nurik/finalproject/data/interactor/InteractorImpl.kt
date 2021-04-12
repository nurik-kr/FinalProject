package kg.nurik.finalproject.data.interactor

import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.bookmaker.Bookmaker
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.model.topScores.TopScores
import kg.nurik.finalproject.data.remote.Service
import retrofit2.Response

interface Interactor {
    suspend fun loadData(): Response<BaseList<Data>>
    suspend fun loadCountry(apiKey: String, continent: String): CountryEntity
    suspend fun searchCountry(apiKey: String, continent: String): Response<BaseList<Data>>
    suspend fun loadLeagues(apiKey: String, country_id: Int): CountryEntity
    suspend fun loadCommands(apiKey: String, country_id: Int): Response<BaseList<Commands>>
    suspend fun loadSeasons(apiKey: String, season_id: Int): Response<BaseSeason<DataSeason>>
    suspend fun loadTopScores(apiKey: String, season_id: Int): Response<BaseSeason<TopScores>>
    suspend fun loadPlayers(apiKey: String, country_id: Int?): Response<BaseList<Players>>
    suspend fun loadBookmaker(apiKey: String): Response<BaseList<Bookmaker>>
}

class InteractorImpl(private val service: Service) : Interactor {

    override suspend fun loadData(): Response<BaseList<Data>> {
        return service.loadData(apiKey)
    }

    override suspend fun loadCountry(apiKey: String, continent: String): CountryEntity {
        return service.loadCountry(apikey = apiKey, continent = continent)
    }

    override suspend fun searchCountry(
        apiKey: String,
        continent: String
    ): Response<BaseList<Data>> {
        return service.searchCountry(apiKey, continent)
    }

    override suspend fun loadLeagues(apiKey: String, country_id: Int): CountryEntity {
        return service.loadLeagues(apikey = apiKey, countryId = country_id)
    }

    override suspend fun loadCommands(
        apiKey: String,
        country_id: Int
    ): Response<BaseList<Commands>> {
        return service.loadCommands(apikey = apiKey, countryId = country_id)
    }

    override suspend fun loadSeasons(
        apiKey: String,
        season_id: Int
    ): Response<BaseSeason<DataSeason>> {
        return service.loadSeasons(
            apikey = apiKey,
            seasonId = season_id
        )
    }

    override suspend fun loadTopScores(
        apiKey: String,
        season_id: Int
    ): Response<BaseSeason<TopScores>> {
        return service.loadTopScores(apikey = apiKey, seasonId = season_id)
    }

    override suspend fun loadPlayers(
        apiKey: String,
        country_id: Int?
    ): Response<BaseList<Players>> {
        return service.loadPlayers(apikey = apiKey, countryId = country_id)
    }

    override suspend fun loadBookmaker(apiKey: String): Response<BaseList<Bookmaker>> {
        return service.loadBookmaker(apiKey)
    }
}