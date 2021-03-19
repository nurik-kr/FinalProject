package kg.nurik.finalproject.data.remote

import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(" api/v1/soccer/countries")
    suspend fun loadData(
        @Query("apikey") apikey: String
    ): Response<BaseList<Data>>

    @GET("api/v1/soccer/countries")
    suspend fun loadCountry(
        @Query("apikey") apikey: String,
        @Query("continent") continent: String
    ): CountryEntity

    @GET("api/v1/soccer/leagues")
    suspend fun loadLeagues(
        @Query("apikey") apikey: String,
        @Query("country_id") countryId: Int
    ): CountryEntity

    @GET("api/v1/soccer/teams")
    suspend fun loadCommands(
        @Query("apikey") apikey: String,
        @Query("country_id") countryId: Int
    ): Response<BaseList<Commands>>

    @GET("api/v1/soccer/matches")
    suspend fun loadSeasons(
        @Query("apikey") apikey: String,
        @Query("season_id") seasonId: Int
    ): Response<BaseSeason<DataSeason>>

    //  https://app.sportdataapi.com/api/v1/soccer/matches?apikey=91edefc0-74f2-11eb-b8af-b7d03964d7a1&
// season_id=496&date_from=2020-09-19

//    https://app.sportdataapi.com/api/v1/soccer/teams?apikey=91edefc0-74f2-11eb-b8af-b7d03964d7a1&country_id=48

}


