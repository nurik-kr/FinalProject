package kg.nurik.finalproject.data.model.players

import com.google.gson.annotations.SerializedName
import kg.nurik.finalproject.data.model.allGames.Data

data class Players(
    @SerializedName("player_id")
    val playerId: String?,
    val firstname: String?,
    val lastname: String?,
    val birthday: String?,
    val age: Int?,
    val weight: Int?,
    val height: Int?,
    val img: String,
    val country: Data?
)