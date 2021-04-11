package kg.nurik.finalproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.model.topScores.TopScores

@Dao
interface CasheDao {

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

    @Transaction
    suspend fun deleteAndInsertTopScores(data: List<TopScores>) {
        deleteAllTopScores()
        insertTopScores(data)
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
    suspend fun deleteAllPlayers()

    @Update
    suspend fun update(item: Commands)

    @Update
    suspend fun updateFavourite(item: FavouriteCommands)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteCommands(data: FavouriteCommands)

    @Delete
    fun deleteFavouriteCommands(data: FavouriteCommands)

    @Query("SELECT ALL * FROM Commands WHERE isChecked")
    fun getFavorite(): LiveData<List<Commands>>

    @Query("SELECT ALL * FROM FavouriteCommands WHERE isChecked")
    fun getNewTableFavorite(): LiveData<List<FavouriteCommands>>

    @Query("SELECT ALL * FROM FavouriteCommands WHERE isChecked")
    fun getTableFavorite(): List<FavouriteCommands>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCommands(data: List<Commands>)

    @Query("SELECT * FROM commands")
    fun getAllCommands(): LiveData<List<Commands>>

    @Query("DELETE FROM commands")
    suspend fun deleteAllCommands()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopScores(data: List<TopScores>)

    @Query("SELECT * FROM topscores")
    fun getAllTopScores(): LiveData<List<TopScores>>

    @Query("DELETE FROM topscores")
    suspend fun deleteAllTopScores()
}