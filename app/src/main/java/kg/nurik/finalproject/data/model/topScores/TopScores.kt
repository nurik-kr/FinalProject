package kg.nurik.finalproject.data.model.topScores

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TopScores(
    @PrimaryKey
    val pos: Int,
    val goals: Goals?,
    val league_id: Int?,
    val matches_played: Int?,
    val minutes_played: Int?,
    val penalties: Int?,
    val player: Player?,
    val season_id: Int?,
    val substituted_in: Int?,
    val team: Team?
): Parcelable