package kg.nurik.finalproject.ui.gamesToSeason

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.season.BaseSeason
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamesSeasonViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    init {
        loadSeason()
    }

    private fun loadSeason() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.loadSeasons(apiKey = "91edefc0-74f2-11eb-b8af-b7d03964d7a1",season_id = 496)
            }.onFailure {
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

    fun getAllSeason(): LiveData<List<DataSeason>> {
        return db.getPagingCasheDao().getAllSeason()
    }

}