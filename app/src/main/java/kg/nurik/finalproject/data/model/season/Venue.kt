package kg.nurik.finalproject.data.model.season

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Venue(
    val capacity: Int?,
    val city: String?,
    @SerializedName("country_id")
    val countryId: Int?,
    val name: String?,
    @SerializedName("venue_id")
    val venueId: Int?
): Parcelable