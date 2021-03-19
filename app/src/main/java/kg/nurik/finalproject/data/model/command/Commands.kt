package kg.nurik.finalproject.data.model.command

import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data

data class Commands(
    @SerializedName("team_id")
    val teamId: String?,
    val name: String?,
    @SerializedName("short_code")
    val shortCode: String?,
    val logo: String?,
    val country: Data?
)