package kg.nurik.finalproject.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.model.season.*

@Database(
    entities = [Data::class, DataSeason::class, Players::class, Commands::class],
    version = 6
)
@TypeConverters(value = [TypeConvertersList::class])
abstract class PagingCasheAppDatabase : RoomDatabase() {
    abstract fun getPagingCasheDao(): PagingCasheDao

    companion object {
        fun getInstanceDB(context: Context): PagingCasheAppDatabase {
            return Room.databaseBuilder(context, PagingCasheAppDatabase::class.java, "myDb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}