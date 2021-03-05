package kg.nurik.finalproject.data.model.allGames

import androidx.room.Entity

@Entity
data class BaseList<T>(
    val data: List<T>
)