package kg.nurik.finalproject.data.repository

import android.util.Log
import kg.nurik.finalproject.BuildConfig
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase

interface Repository {
    suspend fun loadData()
    suspend fun loadSeasons(apiKey: String, season_id: Int)
    suspend fun loadPlayers(apiKey: String, country_id: Int)
    suspend fun loadCommands(apiKey: String, country_id: Int)
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

        val result = network.loadSeasons(apiKey, 496)
        try {
            result.body()?.data?.let { db.getPagingCasheDao().deleteAndInsertSeason(it) }
        } catch (e: Exception) {
            Log.d("season", e.localizedMessage)
        }
    }

    override suspend fun loadPlayers(apiKey: String, country_id: Int) {
        val result =
            network.loadPlayers(apiKey, country_id)
        try {
            result.body()?.data?.let { db.getPagingCasheDao().deleteAndInsertPlayers(it) }
        } catch (e: Exception) {
            Log.d("players", e.localizedMessage)
        }
    }


    override suspend fun loadCommands(apiKey: String, country_id: Int) {
        val result =
            network.loadCommands(apiKey, country_id)
        try {
            result.body()?.data?.let { db.getPagingCasheDao().insertCommands(it) }
        } catch (e: Exception) {
            Log.d("commands", e.localizedMessage)
        }
    }
}
