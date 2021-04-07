package kg.nurik.finalproject.data.model.topScores

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    val player_id: Int?,
    val player_name: String?
): Parcelable