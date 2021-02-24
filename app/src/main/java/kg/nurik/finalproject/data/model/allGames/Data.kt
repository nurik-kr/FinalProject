package kg.nurik.finalproject.data.model.allGames

import com.google.gson.annotations.SerializedName

data class Data(
    val continent: String,
    @SerializedName("country_code")
    val countryCode: Any,
    @SerializedName("country_id")
    val countryId: Int,
    val name: String
)