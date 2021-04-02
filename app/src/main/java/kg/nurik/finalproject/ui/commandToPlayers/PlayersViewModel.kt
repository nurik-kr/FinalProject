package kg.nurik.finalproject.ui.commandToPlayers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    fun loadPlayers(countryId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.loadPlayers(
                    apiKey,
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