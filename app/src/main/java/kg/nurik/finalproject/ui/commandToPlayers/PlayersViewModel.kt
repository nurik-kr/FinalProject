package kg.nurik.finalproject.ui.commandToPlayers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.allGames.BaseList
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    val dataPlayers = MutableLiveData<BaseList<Players>>()

    fun loadPlayers(countryId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.loadPlayers(
                    apiKey = "91edefc0-74f2-11eb-b8af-b7d03964d7a1",
                    country_id = countryId!!
                )
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

    fun getAllPlayers(): LiveData<List<Players>> {
        return db.getPagingCasheDao().getAllPlayers()
    }
}