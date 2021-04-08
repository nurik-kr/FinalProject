package kg.nurik.finalproject.ui.topScorers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.topScores.TopScores
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TopScoresViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    val progress = MutableLiveData<Boolean>(false)

    fun loadTopScores(countryId: Int = 496) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                progress.postValue(true)
                repository.loadTopScores(
                    apiKey,
                    country_id = countryId
                )
                progress.postValue(false)
            }.onFailure {
                progress.postValue(false)
                Log.d("ssasdas", it.localizedMessage)
            }
        }
    }

    fun getTopScores(): LiveData<List<TopScores>> {
        return db.getPagingCasheDao().getAllTopScores()
    }

}