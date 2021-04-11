package kg.nurik.finalproject.ui.leaguesToCommands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.BuildConfig.apiKey
import kg.nurik.finalproject.data.local.ModelWrapper
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeaguesToCommandViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    val data = MutableLiveData<List<Commands>>()
    val progress = MutableLiveData<Boolean>()

    fun loadCommands(countryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            progress.postValue(true)
            runCatching {
                repository.loadCommands(apiKey, country_id = countryId)
                progress.postValue(false)
            }.onFailure {
                progress.postValue(true)
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }

    fun update(item: Commands) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao().update(item)
                insertFavourite(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }

    private fun insertFavourite(item: Commands) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao()
                    .insertFavouriteCommands(ModelWrapper.commandsToFavouriteCommand(item))
            }.onFailure {
                Log.d("FavouriteCommands", it.localizedMessage ?: "no error message")
            }
        }
    }

    fun getAllCommands(): LiveData<List<Commands>> {
        return db.getCasheDao().getAllCommands()
    }

    fun showFavourite(commands: List<Commands>?) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                val favourite = db.getCasheDao().getTableFavorite()
                commands?.forEach { item ->
                    if (favourite.find { it.teamId == item.teamId } != null)
                        item.isChecked = true
                }
                commands?.let { data.postValue(it) }
            }.onFailure {
                Log.d("FavouriteCommands", it.localizedMessage ?: "no error message")
            }
        }

    }
}