package kg.nurik.finalproject.data.interactor

import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.remote.Service
import retrofit2.Response

interface Interactor {
    suspend fun loadData(): Response<BaseList<Data>>
    suspend fun loadCountry(apiKey: String, continent: String): CountryEntity
    suspend fun loadLeagues(apiKey: String, country_id: Int): CountryEntity
    suspend fun loadSeasons(apiKey: String, season_id: Int): Response<BaseSeason<DataSeason>>
}

class InteractorImpl(private val service: Service) : Interactor {

    override suspend fun loadData(): Response<BaseList<Data>> {
        return service.loadData("91edefc0-74f2-11eb-b8af-b7d03964d7a1")
    }

    override suspend fun loadCountry(apiKey: String, continent: String): CountryEntity {
        return service.loadCountry(apikey = apiKey, continent = continent)
    }

    override suspend fun loadLeagues(apiKey: String, country_id: Int): CountryEntity {
        return service.loadLeagues(apikey = apiKey, countryId = country_id)
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
}