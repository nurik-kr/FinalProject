package kg.nurik.finalproject.data.remote

import kg.nurik.finalproject.data.model.allGames.BaseList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(" api/v1/soccer/countries")
    suspend fun loadCategories(
        @Query("apikey") apikey: String
    ): Response<BaseList>

    @GET("api/v1/soccer/countries")
    suspend fun loadCountry(
        @Query("apikey") apikey: String,
        @Query("continent") continent: String
    ): Response<BaseList>

}


