package kg.nurik.finalproject.data.local

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {

    private const val PREFERENCE_NAME = "FinalProject"
    private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"
    private var preference: SharedPreferences? = null

    fun initPreference(context: Context) { // инициализация
        preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setIsFirstLaunch() {
        preference?.edit()?.putBoolean(IS_FIRST_LAUNCH, false)?.apply()
    }

    fun getIsFirstLaunch() = preference?.getBoolean(IS_FIRST_LAUNCH, true) ?: true

}