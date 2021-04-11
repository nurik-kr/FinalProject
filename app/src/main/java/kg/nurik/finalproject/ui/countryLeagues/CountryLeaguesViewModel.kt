package kg.nurik.finalproject.ui.countryLeagues

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kg.nurik.finalproject.data.model.leagues.Leagues
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryLeaguesViewModel(private val service: Interactor) : ViewModel() {

    val dataLeagues = MutableLiveData<BaseList<Leagues>>()

    fun loadLeagues(leagues: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result =
                    service.loadLeagues(apiKey, leagues)
                parseJsonObject(result)
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage?: "no error message")
            }
        }
    }

    private fun parseJsonObject(result: CountryEntity) {
        val keys = result.data.keySet().toList()
        val list = arrayListOf<Leagues>()

        if (keys != null) {
            for (item in keys) {
                val value = result.data.get(item).toString()
                val json = Gson().fromJson(value, Leagues::class.java)
                list.add(json)
            }
        }
        dataLeagues.postValue(BaseList(list))
    }
}