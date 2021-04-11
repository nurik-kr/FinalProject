package kg.nurik.finalproject.ui.bottomNav.myCommands

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.finalproject.data.local.CasheAppDatabase
import kg.nurik.finalproject.data.model.command.FavouriteCommands
import kg.nurik.finalproject.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyCommandsViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    fun update(item: FavouriteCommands) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao().updateFavourite(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage?: "no error message")
            }
        }
    }

    fun getAllFavouriteCommands(): LiveData<List<FavouriteCommands>> {
        return db.getCasheDao().getNewTableFavorite()
    }
}