package kg.nurik.finalproject.data.model.command

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Commands(
    @PrimaryKey
    @SerializedName("team_id")
    val teamId: String,
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    val logo: String?,
    val country: Data?
): Parcelable