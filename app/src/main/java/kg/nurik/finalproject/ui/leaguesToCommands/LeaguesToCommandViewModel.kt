package kg.nurik.finalproject.ui.leaguesToCommands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeaguesToCommandViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    fun loadCommands(countryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.loadCommands(
                    apiKey,
                    country_id = countryId
                )
            }.onFailure {
                Log.d("commands", it.localizedMessage)
            }
        }
    }

    fun update(item: Commands) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                db.getPagingCasheDao().update(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage)
            }
        }
    }

    fun getAllCommands(): LiveData<List<Commands>> {
        return db.getPagingCasheDao().getAllCommands()
    }
}