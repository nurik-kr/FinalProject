package kg.nurik.finalproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason

@Dao
interface PagingCasheDao {

    @Transaction
    suspend fun deleteAndInsertAllGames(data: List<Data>) {
        deleteAllGames()
        insertAlGames(data)
    }

    @Transaction
    suspend fun deleteAndInsertSeason(data: List<DataSeason>) {
        deleteAllSeason()
        insertSeason(data)
    }

    @Transaction
    suspend fun deleteAndInsertPlayers(data: List<Players>) {
        deleteAllPlayers()
        insertPlayers(data)
    }

    @Transaction
    suspend fun deleteAndInsertCommands(data: List<Commands>) {
        deleteAllCommands()
        insertCommands(data)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlGames(data: List<Data>)

    @Query("SELECT * FROM data")
    fun getAllGames(): LiveData<List<Data>>

    @Query("DELETE FROM data")
    suspend fun deleteAllGames()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeason(data: List<DataSeason>)

    @Query("SELECT * FROM dataseason")
    fun getAllSeason(): LiveData<List<DataSeason>>

    @Query("DELETE FROM dataseason")
    suspend fun deleteAllSeason()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayers(data: List<Players>)

    @Query("SELECT * FROM players")
    fun getAllPlayers(): LiveData<List<Players>>

    @Query("DELETE FROM players")
    suspend fun  deleteAllPlayers()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCommands(data: List<Commands>)

    @Query("SELECT * FROM commands")
    fun getAllCommands(): LiveData<List<Commands>>

    @Query("DELETE FROM commands")
    suspend fun  deleteAllCommands()
}