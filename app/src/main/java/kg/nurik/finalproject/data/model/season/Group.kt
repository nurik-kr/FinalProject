package kg.nurik.finalproject.data.model.season

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Group(
    val group_id: Int?,
    val group_name: String?
): Parcelable