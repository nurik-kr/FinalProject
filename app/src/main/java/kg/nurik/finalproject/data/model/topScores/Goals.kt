package kg.nurik.finalproject.data.model.topScores

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Goals(
    val away: Int?,
    val home: Int?,
    val overall: Int?
): Parcelable