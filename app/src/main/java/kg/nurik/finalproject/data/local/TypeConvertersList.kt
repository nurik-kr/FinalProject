package kg.nurik.finalproject.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.season.*
import kg.nurik.finalproject.data.model.topScores.Goals
import kg.nurik.finalproject.data.model.topScores.Player
import kg.nurik.finalproject.data.model.topScores.Team

object TypeConvertersList {

    @JvmStatic
    @TypeConverter
    fun goalsListToString(model: Goals?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToGoalsList(text: String?): Goals? {
        if (text == null) return null
        val typeToken = object : TypeToken<Goals>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun playerListToString(model: Player?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToPlayerList(text: String?): Player? {
        if (text == null) return null
        val typeToken = object : TypeToken<Player>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun teamListToString(model: Team?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToTeamList(text: String?): Team? {
        if (text == null) return null
        val typeToken = object : TypeToken<Team>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun awayTeamListToString(model: AwayTeam?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToAwayTeamList(text: String?): AwayTeam? {
        if (text == null) return null
        val typeToken = object : TypeToken<AwayTeam>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun groupListToString(model: Group?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToGroupList(text: String?): Group? {
        if (text == null) return null
        val typeToken = object : TypeToken<Group>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun homeTeamListToString(model: HomeTeam?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToHomeTeamList(text: String?): HomeTeam? {
        if (text == null) return null
        val typeToken = object : TypeToken<HomeTeam>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun statsListToString(model: Stats?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToStatsList(text: String?):Stats? {
        if (text == null) return null
        val typeToken = object : TypeToken<Stats>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun venueListToString(model: Venue?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToVenueList(text: String?): Venue? {
        if (text == null) return null
        val typeToken = object : TypeToken<Venue>() {}.type
        return Gson().fromJson(text, typeToken)
    }

    @JvmStatic
    @TypeConverter
    fun dataListToString(model:Data?): String {
        return Gson().toJson(model)
    }

    @JvmStatic
    @TypeConverter
    fun textStringToDataList(text: String?): Data? {
        if (text == null) return null
        val typeToken = object : TypeToken<Data>() {}.type
        return Gson().fromJson(text, typeToken)
    }
}