package kg.nurik.finalproject.ui.countryDetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kg.nurik.finalproject.BuildConfig
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.countryDet.CountryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryDetailsViewModel(private val service: Interactor) : ViewModel() {

    val dataCountry = MutableLiveData<BaseList<Data>>()

    fun loadCountry(continent: String) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result =
                    service.loadCountry(apiKey, continent)
                parseJsonObject(result)
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

    private fun parseJsonObject(result: CountryEntity) {
        val keys = result.data.keySet().toList()
        val list = arrayListOf<Data>()

        if (keys != null) {
            for (item in keys) {
                val value = result.data.get(item).toString()
                val json = Gson().fromJson(value, Data::class.java)
                list.add(json)
            }
        }
        dataCountry.postValue(BaseList(list))
    }
}