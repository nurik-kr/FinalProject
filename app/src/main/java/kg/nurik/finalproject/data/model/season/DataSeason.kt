package kg.nurik.finalproject.data.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DataSeason(
    @PrimaryKey
    val match_id: Int,
    val status_code: Int?,
    val status: String?,
    val match_start: String?,
    val league_id: Int?,
    val season_id: Int?,
    val referee_id: Int?,
    val group: Group?,
    @SerializedName("home_team")
    val homeTeam: HomeTeam?,
    @SerializedName("away_team")
    val awayTeam: AwayTeam?,
    val stats: Stats?,
    val venue: Venue?
)