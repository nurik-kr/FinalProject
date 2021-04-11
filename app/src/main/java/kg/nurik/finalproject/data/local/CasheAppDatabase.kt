package kg.nurik.finalproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.*
import kg.nurik.finalproject.data.model.topScores.TopScores

@Database(
    entities = [Data::class, DataSeason::class, Players::class, Commands::class,
        FavouriteCommands::class, TopScores::class],
    version = 8
)
@TypeConverters(value = [TypeConvertersList::class])
abstract class CasheAppDatabase : RoomDatabase() {
    abstract fun getCasheDao(): CasheDao

    companion object {
        fun getInstanceDB(context: Context): CasheAppDatabase {
            return Room.databaseBuilder(context, CasheAppDatabase::class.java, "myDb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}