package kg.nurik.finalproject.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.nurik.finalproject.data.model.allGames.Data
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
}