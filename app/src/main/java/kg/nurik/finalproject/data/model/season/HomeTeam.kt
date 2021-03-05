package kg.nurik.finalproject.data.model.season

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data


data class HomeTeam(

    val logo: String?,
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    val country: Data?
)