package kg.nurik.finalproject.ui.commandToPlayers

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.interactor.Interactor
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.players.Players
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(private val service: Interactor) : ViewModel() {

    val dataPlayers = MutableLiveData<BaseList<Players>>()

    fun loadPlayers(countryId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result =
                    service.loadPlayers("91edefc0-74f2-11eb-b8af-b7d03964d7a1", country_id = countryId)
                dataPlayers.postValue(result.body())
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

}