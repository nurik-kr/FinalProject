package kg.nurik.finalproject.data.model.onBoard

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OnBoardModel(
    val title: String,
    val image: Int
) : Parcelable