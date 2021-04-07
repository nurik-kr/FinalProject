package kg.nurik.finalproject.data.remote

import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.model.topScores.TopScores
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("api/v1/soccer/countries")
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

    @GET("api/v1/soccer/topscorers")
    suspend fun loadTopScores(
        @Query("apikey") apikey: String,
        @Query("season_id") seasonId: Int
    ): Response<BaseSeason<TopScores>>

    @GET("api/v1/soccer/players")
    suspend fun loadPlayers(
        @Query("apikey") apikey: String,
        @Query("country_id") countryId: Int?
    ): Response<BaseList<Players>>

}


