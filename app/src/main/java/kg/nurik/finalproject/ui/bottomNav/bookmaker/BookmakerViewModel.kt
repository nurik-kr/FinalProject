package kg.nurik.finalproject.ui.bottomNav.bookmaker

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.allGames.Data
import kg.nurik.finalproject.data.model.bookmaker.Bookmaker
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmakerViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    init {
        loadBookmaker()
    }

    private fun loadBookmaker() {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                repository.loadBookmaker(apiKey)
            }.onFailure {
                Log.d("Error", it.localizedMessage ?: "no error message")
            }
        }
    }

    fun getAllBookmaker(): LiveData<List<Bookmaker>> {
        return db.getCasheDao().getAllBookmaker()
    }
}