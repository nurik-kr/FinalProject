package kg.nurik.finalproject.data.model.leagues

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leagues(
    @SerializedName("league_id")
    val leagueId: Int,
    @SerializedName("country_id")
    val countryId: Int,
    val name: String
) : Parcelable