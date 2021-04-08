package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.PagingCasheAppDatabase
import kg.nurik.finalproject.data.model.command.Commands
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyCommandsViewModel(
    private val repository: Repository,
    private val db: PagingCasheAppDatabase
) : ViewModel() {

    fun update(item: FavouriteCommands) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                db.getPagingCasheDao().updateFavourite(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage)
            }
        }
    }

    fun getAllFavouriteCommands(): LiveData<List<FavouriteCommands>> {
        return db.getPagingCasheDao().getNewTableFavorite()
    }
}