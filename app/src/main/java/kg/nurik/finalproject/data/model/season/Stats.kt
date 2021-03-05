package kg.nurik.finalproject.data.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Stats(

    @SerializedName("away_score")
    val awayScore: Int?,
    @SerializedName("ft_score")
    val ftScore: String?,
    @SerializedName("home_score")
    val homeScore: Int?
)