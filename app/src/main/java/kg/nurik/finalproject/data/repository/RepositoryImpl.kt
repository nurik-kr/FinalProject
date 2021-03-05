package kg.nurik.finalproject.data.repository

import android.util.Log
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import retrofit2.Response

interface Repository {
    suspend fun loadData()
    suspend fun loadSeasons(apiKey: String, season_id: Int)
}

class RepositoryImpl(
    private val network: Interactor,
    private val db: PagingCasheAppDatabase
) : Repository {
    override suspend fun loadData() {
        val result = network.loadData()
        result.body()?.let { db.getPagingCasheDao().deleteAndInsertAllGames(it.data) }
    }

    override suspend fun loadSeasons(apiKey: String, season_id: Int) {

        val result = network.loadSeasons("91edefc0-74f2-11eb-b8af-b7d03964d7a1", 496)
        try {
            result.body()?.data?.let { db.getPagingCasheDao().deleteAndInsertSeason(it) }
        } catch (e: Exception) {
            Log.d("ssasdas", e.localizedMessage)
        }
    }
}
