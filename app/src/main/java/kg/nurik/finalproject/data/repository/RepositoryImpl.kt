package kg.nurik.finalproject.data.repository

import android.util.Log
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.local.CasheAppDatabase
import org.koin.android.ext.koin.ERROR_MSG

interface Repository {
    suspend fun loadData()
    suspend fun loadSeasons(apiKey: String, season_id: Int)
    suspend fun loadPlayers(apiKey: String, country_id: Int)
    suspend fun loadCommands(apiKey: String, country_id: Int)
    suspend fun loadTopScores(apiKey: String, country_id: Int)
    suspend fun loadBookmaker(apiKey: String)
}


class RepositoryImpl(
    private val network: Interactor,
    private val db: CasheAppDatabase
) : Repository {
    override suspend fun loadData() {
        val result = network.loadData()
        result.body()?.let { db.getCasheDao().deleteAndInsertAllGames(it.data) }
    }

    override suspend fun loadSeasons(apiKey: String, season_id: Int) {

        val result = network.loadSeasons(apiKey, season_id)
        try {
            result.body()?.data?.let { db.getCasheDao().deleteAndInsertSeason(it) }
        } catch (e: Exception) {
            Log.d("season", e.localizedMessage?: ERROR_MSG)
        }
    }

    override suspend fun loadPlayers(apiKey: String, country_id: Int) {
        val result =
            network.loadPlayers(apiKey, country_id)
        try {
            result.body()?.data?.let { db.getCasheDao().deleteAndInsertPlayers(it) }
        } catch (e: Exception) {
            Log.d("players", e.localizedMessage?: ERROR_MSG)
        }
    }


    override suspend fun loadCommands(apiKey: String, country_id: Int) {
        val result =
            network.loadCommands(apiKey, country_id)
        try {
            result.body()?.data?.let { db.getCasheDao().deleteAndInsertCommands(it) }
        } catch (e: Exception) {
            Log.d("commands", e.localizedMessage?: ERROR_MSG)
        }
    }

    override suspend fun loadTopScores(apiKey: String, country_id: Int) {
        val result = network.loadTopScores(apiKey, country_id)
        try {
            result.body()?.data?.let { db.getCasheDao().deleteAndInsertTopScores(it) }
        } catch (e: Exception) {
            Log.d("commands", e.localizedMessage?: ERROR_MSG)
        }
    }

    override suspend fun loadBookmaker(apiKey: String) {
        val result = network.loadBookmaker(apiKey)
        try {
            result.body()?.data?.let { db.getCasheDao().insertBookmaker(it) }
        } catch (e: Exception) {
            Log.d("commands", e.localizedMessage?: ERROR_MSG)
        }
    }
}
