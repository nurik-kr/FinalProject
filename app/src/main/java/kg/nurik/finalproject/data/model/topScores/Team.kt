package kg.nurik.finalproject.data.model.topScores

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val team_id: Int?,
    val team_name: String?
): Parcelable