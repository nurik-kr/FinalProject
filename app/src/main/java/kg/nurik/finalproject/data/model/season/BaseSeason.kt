package kg.nurik.finalproject.data.model.season

import androidx.room.Entity

@Entity
data class BaseSeason<T>(
    val data: List<T>
)