package kg.nurik.finalproject.data.model.players

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Players(
    @PrimaryKey
    @SerializedName("player_id")
    val playerId: String,
    val firstname: String?,
    val lastname: String?,
    val birthday: String?,
    val age: Int?,
    val weight: Int?,
    val height: Int?,
    val img: String,
    val country: Data?
): Parcelable