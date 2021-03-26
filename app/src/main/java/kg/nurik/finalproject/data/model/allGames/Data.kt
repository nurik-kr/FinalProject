package kg.nurik.finalproject.data.model.allGames

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Data(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("country_id")
    var countryId: Int?,
    val name: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    val continent: String?
) : Parcelable