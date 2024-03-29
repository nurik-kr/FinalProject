package kg.nurik.finalproject.ui.commandToPlayers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    val progress = MutableLiveData<Boolean>()

    fun loadPlayers(countryId: Int?) {
        viewModelScope.launch(Dispatchers.Default) {
            progress.postValue(true)
            runCatching {
                repository.loadPlayers(apiKey, country_id = countryId!!)
                progress.postValue(false)
            }.onFailure {
                progress.postValue(true)
                Log.d("ssasdas", it.localizedMessage?: "no error message")
            }
        }
    }

    fun getAllPlayers(): LiveData<List<Players>> {
        return db.getCasheDao().getAllPlayers()
    }
}