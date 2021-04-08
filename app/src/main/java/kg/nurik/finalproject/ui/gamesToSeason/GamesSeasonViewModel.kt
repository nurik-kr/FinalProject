package kg.nurik.finalproject.ui.gamesToSeason

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.season.DataSeason
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GamesSeasonViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    val progress = MutableLiveData<Boolean>(false)

    fun loadSeason(seasonId: Int = 496) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                progress.postValue(true)
                repository.loadSeasons(
                    apiKey,
                    season_id = seasonId
                )
                progress.postValue(false)
            }.onFailure {
                progress.postValue(false)
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

    fun getAllSeason(): LiveData<List<DataSeason>> {
        return db.getPagingCasheDao().getAllSeason()
    }

}