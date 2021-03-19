package kg.nurik.finalproject.data.model.season

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeTeam(
    val logo: String?,
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    val country: Data?
): Parcelable