package kg.nurik.finalproject.ui.commandToPlayers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.players.Players
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    fun loadPlayers(countryId: Int?) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                repository.loadPlayers(apiKey, country_id = countryId!!)
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage?: "no error message")
            }
        }
    }

    fun getAllPlayers(): LiveData<List<Players>> {
        return db.getCasheDao().getAllPlayers()
    }
}